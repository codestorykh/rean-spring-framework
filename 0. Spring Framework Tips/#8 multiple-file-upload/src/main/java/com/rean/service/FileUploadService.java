package com.rean.service;

import com.rean.dto.FileUploadResponse;
import com.rean.model.FileUpload;
import com.rean.repository.FileUploadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileUploadService {

    @Value("${upload.files.extensions}")
    private String fileExtensions;
    @Value("${upload.files.path}")
    private String uploadPath;

    private final ModelMapper modelMapper;
    private final FileUploadRepository fileUploadRepository;

    public List<FileUploadResponse> upload(MultipartFile[] uploadingFiles, Map<String, String> headers) {

        if (uploadingFiles == null) {
            log.error("Invalid File Upload");
            throw new IllegalArgumentException("Invalid File");
        }

        List<FileUpload> fileUploads = new ArrayList<>();

        Arrays.stream(uploadingFiles).forEach(file -> {
            try {
                byte[] bytes = file.getBytes();
                Files.write(Paths.get(uploadPath + file.getOriginalFilename()), bytes);

                String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                fileName = fileName.replace("#", "");
                String fileExtension = getFileExtension(fileName);

                if (!fileExtensions.contains(fileExtension.toLowerCase())) {
                    log.error("Invalid file extension {}", fileExtension);
                    throw new IllegalArgumentException("Invalid File");
                }

                String fileNameUpload = FilenameUtils.removeExtension(fileName) + "_" + Calendar.getInstance().getTimeInMillis() + "." + getFileExtension(fileName);

                FileUpload fileUpload = new FileUpload();
                fileUpload.setExtensionName(getFileExtension(fileName));
                fileUpload.setFileSize(file.getSize());
                fileUpload.setFullPath(uploadPath+fileName);
                fileUpload.setFileName(fileNameUpload);
                String fileNameNoExt = FilenameUtils.removeExtension(fileName);
                fileUpload.setFileNameOriginal(fileNameNoExt);
                fileUpload.setChannelCode(headers.get("channel-code"));
                fileUpload.setStatus(true);
                fileUploads.add(fileUpload);
            } catch (IOException e) {
                log.error("Upload file error {}", e.getLocalizedMessage());
            }
        });

        fileUploadRepository.saveAll(fileUploads);
        return fileUploads.stream()
                .map(m -> modelMapper.map(m, FileUploadResponse.class))
                .collect(Collectors.toList());
    }
    String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex < 0) {
            return null;
        }
        return fileName.substring(dotIndex + 1);
    }

}
