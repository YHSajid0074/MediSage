package com.example.MediSage.config.image.service.impl;

import com.cloudinary.Cloudinary;
import com.example.MediSage.config.image.service.CloudneryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudneryImageServiceImpl implements CloudneryImageService {

    @Autowired
    public Cloudinary cloudinary;

    @Override
    public Map<String, Object> upload(MultipartFile file) throws IOException {
        Map<String, Object> options = new HashMap<>();


        if (file.getContentType() != null && file.getContentType().contains("pdf")) {
            options.put("resource_type", "raw");
        }

        Map<String, Object> data = this.cloudinary.uploader().upload(file.getBytes(), options);
        return data;
    }
}