package com.example.MediSage.config.mail;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {
    private final Map<String, String> otpStorage = new HashMap<>();
    private final Random random = new SecureRandom();

    // Generate 6-digit OTP
    public String generateOtp(String email) {
        String otp = String.format("%06d", random.nextInt(1000000)); // 6-digit OTP
        otpStorage.put(email, otp);
        return otp;
    }

    // Verify OTP
    public boolean verifyOtp(String email, String otp) {
        return otp.equals(otpStorage.get(email));
    }

    // Remove OTP after verification or timeout
    public void removeOtp(String email) {
        otpStorage.remove(email);
    }
}

