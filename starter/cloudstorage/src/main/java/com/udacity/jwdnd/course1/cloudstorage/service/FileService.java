package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public Integer saveFile(int user, MultipartFile fileRequest) {

        File file1 = new File();
        file1.setFilename(fileRequest.getName());
        file1.setFilesize(String.valueOf(fileRequest.getSize()));
        file1.setContenttype(fileRequest.getContentType());
        file1.setUserid(0);
        file1.setFileData(fileRequest);

        return this.fileMapper.insert(fileRequest);
    }
}
