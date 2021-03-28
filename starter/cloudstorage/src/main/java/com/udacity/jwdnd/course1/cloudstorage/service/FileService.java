package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public Integer saveFile(Authentication authentication, MultipartFile fileRequest) {
        return this.fileMapper.insert(buildFile(authentication, fileRequest));
    }

    private File buildFile(Authentication authentication, MultipartFile fileRequest) {
        User user = (User)authentication.getPrincipal();
        File file = new File();
        file.setFilename(fileRequest.getName());
        file.setFilesize(String.valueOf(fileRequest.getSize()));
        file.setContenttype(fileRequest.getContentType());
        file.setUserid(user.getUserId());
        file.setFileData(fileRequest);
        return file;
    }
}
