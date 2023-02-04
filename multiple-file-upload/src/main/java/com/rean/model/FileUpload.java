package com.rean.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_file_upload")
public class FileUpload implements Serializable {

    private static final long serialVersionUID = -9082333384269286004L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "extension_name")
    private String extensionName;

    @Column(name = "file_name_original")
    private String fileNameOriginal;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "full_path")
    private String fullPath;

    @Column(name = "channel_code")
    private String channelCode;

    @Column(name = "status")
    private boolean status;

    @Column(name = "created_on")
    private LocalDateTime localDateTime = LocalDateTime.now();
}

