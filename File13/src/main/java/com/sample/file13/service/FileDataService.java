package com.sample.file13.service;

import com.sample.file13.domain.FileEntity;
import com.sample.file13.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Log4j2
@Service
@RequiredArgsConstructor
public class FileDataService {
    private final String FOLDER_PATH ="c:\\images\\";
    private final FileDataRepository fileDataRepository;

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        log.info("upload file : " + file.getOriginalFilename());
        String filePath = FOLDER_PATH + file.getOriginalFilename();

        FileEntity fileData = fileDataRepository.save(
                FileEntity.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .filePath(filePath)
                        .build()
        );
        file.transferTo(new File(filePath));
        if(filePath != null){
            return "file upload success" + filePath;
        }
        return null;
    }
}
