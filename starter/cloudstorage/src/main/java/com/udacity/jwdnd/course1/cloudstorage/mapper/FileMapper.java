package com.udacity.jwdnd.course1.cloudstorage.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface FileMapper {

    @Insert("INSERT INTO FILES (file) VALUES( #{file} )")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(MultipartFile file);

}
