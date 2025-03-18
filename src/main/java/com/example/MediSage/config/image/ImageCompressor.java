package com.example.MediSage.config.image;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageCompressor {

    public static byte[] compressImageToMaxSize(MultipartFile file, int maxWidth, int maxHeight, float initialQuality, long maxSizeKB) throws IOException {
        ByteArrayOutputStream outputStream;
        float quality = initialQuality;

        do {
            outputStream = new ByteArrayOutputStream();
            Thumbnails.of(file.getInputStream())
                    .size(maxWidth, maxHeight)
                    .outputQuality(quality)
                    .toOutputStream(outputStream);

            if (outputStream.toByteArray().length <= maxSizeKB * 1024) {
                break;
            }

            quality -= 0.05f;
        } while (quality > 0.1f);

        return outputStream.toByteArray();
    }
}

