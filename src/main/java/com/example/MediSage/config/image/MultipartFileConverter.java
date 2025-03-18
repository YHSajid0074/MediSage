package com.example.MediSage.config.image;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MultipartFileConverter implements Converter<String, MultipartFile> {
    @Override
    public MultipartFile convert(String source) {
        return null;
    }
}
