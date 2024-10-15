package com.sample.file13.controller;

import com.sample.file13.service.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FileController {
    @Autowired
    FileDataService fileDataService;

    @PostMapping("/file")
    public ResponseEntity<?> uploadImage (
            @RequestParam("images") List<MultipartFile> files
            ) throws IOException {
        List<String> uploadResult = files.stream()
                .map(file -> {
                    try {
                        return fileDataService.uploadImageToFileSystem(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "failed";
                    }
                })
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(uploadResult);
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<?> downImage (@PathVariable("id") Long id) throws IOException {
        byte[] downloadImage = fileDataService.downloadImageFileSystem(id);

        if(downloadImage != null) { // 파일있으면
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf("image/png"))
                    .body(downloadImage);
        }else{ // 파일없으면
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
