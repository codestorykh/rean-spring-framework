package com.rean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FileUploadResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("extension_name")
    private String extensionName;

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("file_name_original")
    private String fileNameOriginal;

    @JsonProperty("full_path")
    private String fullPath;

    @JsonProperty("file_size")
    private Long fileSize;

    @JsonProperty("channel_code")
    private String channelCode;

    @JsonProperty("created_on")
    private LocalDateTime localDateTime;
}
