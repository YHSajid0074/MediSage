package com.example.MediSage.config.image;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProjectConfig {

    @Bean
    public Cloudinary getCloudinary() {
        Map config=new HashMap<>();
        config.put("cloud_name", "dxmwiwy6g");
        config.put("api_key", "539746916824996");
        config.put("api_secret", "ELzRDZMRtY1fA-DCqfrRrnHKXZM");
     return new Cloudinary(config);
    }
}
