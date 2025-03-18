package com.example.MediSage.config.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtpEmail(String toEmail, String otp) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("UniChain: Your OTP Code for Registration");

            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'>" +
                    "<h2 style='color: #2c3e50; text-align: center;'>Welcome to UniChain!</h2>" +
                    "<p style='font-size: 16px; color: #34495e;'>Thank you for choosing UniChain, your all-in-one university platform. With UniChain, you can easily manage all aspects of your university life, from academic details to campus services. We're excited to have you as part of our community!</p>" +
                    "<p style='font-size: 16px; color: #34495e;'>To complete your registration, please use the One-Time Password (OTP) below:</p>" +
                    "<h3 style='font-size: 32px; color: #2980b9; font-weight: bold; text-align: center;'>"
                    + otp + "</h3>" +
                    "<p style='font-size: 16px; color: #34495e;'>This OTP is valid for 5 minutes, and it's required to verify your account. If you did not request this, please ignore this email or contact support.</p>" +
                    "<br>" +
                    "<p style='font-size: 16px; color: #34495e;'>Best regards,</p>" +
                    "<p style='font-size: 16px; color: #34495e;'>The UniChain Team</p>" +
                    "<footer style='font-size: 12px; color: #95a5a6; text-align: center;'>" +
                    "UniChain | Empowering Students with Seamless University Management</footer>" +
                    "</body>" +
                    "</html>";


            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }


    }


    public void sendAnnouncementEmail(String toEmail, String announcement) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("🚍 UniChain Bus Service Announcement");

            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'>" +
                    "<div style='max-width: 600px; margin: auto; background: #ffffff; padding: 20px; border-radius: 10px; " +
                    "box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);'>" +
                    "<h2 style='color: #2c3e50; text-align: center;'>🚍 Important Bus Service Update</h2>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>" +
                    announcement + "</p>" +
                    "<div style='text-align: center; margin-top: 20px;'>" +
                    "<a href='https://unichain-ac-bd.web.app/bus-routes' style='background-color: #2980b9; color: #ffffff; padding: 12px 20px; " +
                    "text-decoration: none; font-weight: bold; border-radius: 5px; display: inline-block;'>Check Updates</a>" +
                    "</div>" +
                    "<br>" +
                    "<p style='font-size: 14px; color: #95a5a6; text-align: center;'>Stay updated with UniChain for all university services.</p>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void sendUpcomingEventEmail(String toEmail, String eventTitle, String eventDescription, String eventDate) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("🎉 Exciting Upcoming Event: " + eventTitle);


            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'>" +
                    "<div style='max-width: 600px; margin: auto; background: #ffffff; padding: 20px; border-radius: 10px; " +
                    "box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);'>" +
                    "<h2 style='color: #2c3e50; text-align: center;'>🎉 Exciting News! " + eventTitle + " is Coming Soon!</h2>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>We are thrilled to announce an upcoming event that you won’t want to miss!</p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Event: <strong>" + eventTitle + "</strong></p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Description: " + eventDescription + "</p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Date: <strong>" + eventDate + "</strong></p>" +
                    "<div style='text-align: center; margin-top: 20px;'>" +
                    "<a href='https://unichain-ac-bd.web.app/event' style='background-color: #2980b9; color: #ffffff; padding: 12px 20px; " +
                    "text-decoration: none; font-weight: bold; border-radius: 5px; display: inline-block;'>RSVP Now</a>" +
                    "</div>" +
                    "<br>" +
                    "<p style='font-size: 14px; color: #95a5a6; text-align: center;'>Don’t miss out on this exciting opportunity! We can’t wait to see you there!</p>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }


    public void sendUpcomingExamScheduleEmail(String toEmail, String examTitle, Long examDate, LocalDate localDate) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("📅 Upcoming Exam: " + examTitle);


            String formattedExamDate = localDate.toString();


            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px;'>" +
                    "<div style='max-width: 600px; margin: auto; background: #ffffff; padding: 20px; border-radius: 10px; " +
                    "box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);'>" +
                    "<h2 style='color: #2c3e50; text-align: center;'>📅 Upcoming Exam: " + examTitle + "</h2>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>We are excited to inform you about your upcoming exam. Make sure you’re prepared!</p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Exam: <strong>" + examTitle + "</strong></p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Date: <strong>" + formattedExamDate + "</strong></p>" +
                    "<div style='text-align: center; margin-top: 20px;'>" +
                    "<a href='https://unichain-ac-bd.web.app/exam-schedule' style='background-color: #2980b9; color: #ffffff; padding: 12px 20px; " +
                    "text-decoration: none; font-weight: bold; border-radius: 5px; display: inline-block;'>View Full Schedule</a>" +
                    "</div>" +
                    "<br>" +
                    "<p style='font-size: 14px; color: #95a5a6; text-align: center;'>Prepare well and best of luck! We’re cheering for you!</p>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void sendEmergencyAlertEmail(String toEmail, String alertType, String alertTime) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("🚨 Emergency Alert: " + alertType);

            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #fff5f5; padding: 20px;'>" +
                    "<div style='max-width: 600px; margin: auto; background: #ffffff; padding: 20px; border-radius: 10px; " +
                    "box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);'>" +
                    "<h2 style='color: #c0392b; text-align: center;'>🚨 Emergency Alert: " + alertType + "</h2>" +
                    "<p style='font-size: 16px; color: #e74c3c; text-align: center;'>An emergency alert has been issued. Please take immediate action if necessary.</p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Alert Type: <strong>" + alertType + "</strong></p>" +
                    "<p style='font-size: 16px; color: #34495e; text-align: center;'>Time: <strong>" + alertTime + "</strong></p>" +
                    "<div style='text-align: center; margin-top: 20px;'>" +
                    "<a href='https://unichain-ac-bd.web.app/updateandannounce' style='background-color: #c0392b; color: #ffffff; padding: 12px 20px; " +
                    "text-decoration: none; font-weight: bold; border-radius: 5px; display: inline-block;'>View Emergency Info</a>" +
                    "</div>" +
                    "<br>" +
                    "<p style='font-size: 14px; color: #7f8c8d; text-align: center;'>Stay safe and follow necessary precautions.</p>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send emergency alert email", e);
        }
    }


    public void sendStudentQueryEmail(String queryText, String studentName, String studentId, String studentEmail, String studentContact, String facultyEmail) {
        try {

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(facultyEmail);
            helper.setSubject("📚 New Student Query from " + studentName);

            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; background-color: #f4f7fc; padding: 20px;'>" +
                    "<div style='max-width: 650px; margin: auto; background: #ffffff; padding: 25px; border-radius: 8px; box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.1);'>" +
                    "<h2 style='color: #3498db; text-align: center; font-size: 24px; font-weight: 600;'>New Student Query</h2>" +
                    "<p style='font-size: 16px; color: #34495e;'>Dear Faculty,</p>" +
                    "<p style='font-size: 16px; color: #34495e;'>You have received a new query from a student. Below are the details:</p>" +
                    "<table style='width: 100%; margin-top: 20px; border-collapse: collapse;'>" +
                    "<tr><td style='padding: 8px; font-size: 16px; color: #34495e; font-weight: bold;'>Student Name:</td><td style='padding: 8px; font-size: 16px; color: #2c3e50;'>" + studentName + "</td></tr>" +
                    "<tr><td style='padding: 8px; font-size: 16px; color: #34495e; font-weight: bold;'>Student ID:</td><td style='padding: 8px; font-size: 16px; color: #2c3e50;'>" + studentId + "</td></tr>" +
                    "<tr><td style='padding: 8px; font-size: 16px; color: #34495e; font-weight: bold;'>Student Email:</td><td style='padding: 8px; font-size: 16px; color: #2c3e50;'>" + studentEmail + "</td></tr>" +
                    "<tr><td style='padding: 8px; font-size: 16px; color: #34495e; font-weight: bold;'>Student Contact:</td><td style='padding: 8px; font-size: 16px; color: #2c3e50;'>" + studentContact + "</td></tr>" +
                    "</table>" +
                    "<p style='font-size: 16px; color: #e74c3c; margin-top: 30px; font-weight: bold;'>Student's Query:</p>" +
                    "<blockquote style='font-size: 16px; color: #34495e; border-left: 4px solid #3498db; padding-left: 15px; margin-left: 0px;'>" +
                    "<p style='margin: 0px;'>" + queryText + "</p>" +
                    "</blockquote>" +
                    "<p style='font-size: 14px; color: #7f8c8d; text-align: center; margin-top: 30px;'>Please respond to the student's query at your earliest convenience. If you have any further questions, feel free to reach out.</p>" +
                    "<div style='text-align: center; margin-top: 30px;'>" +
                    "<a href='mailto:" + facultyEmail + "' style='background-color: #3498db; color: #ffffff; padding: 12px 20px; text-decoration: none; font-weight: bold; border-radius: 5px; display: inline-block;'>Reply to Query</a>" +
                    "</div>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send query email", e);
        }
    }



}


