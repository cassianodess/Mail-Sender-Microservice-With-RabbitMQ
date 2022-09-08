package com.cassianodess.ms.services;


import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cassianodess.ms.DTO.EmailDTO;
import com.cassianodess.ms.models.Email;
import com.cassianodess.ms.repositories.EmailRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailService {
    
    @Autowired
    private EmailRepository repository;
    
    @Autowired
    private JavaMailSender emailSender;

    public Email sendEmail(EmailDTO emailDTO) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);
        email.setSendDateTime(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);
            email.setStatusEmail(true);
            log.info("Email sent successfully");
            
        } catch (Exception e) {
            log.error("Error sending email");
            email.setStatusEmail(false);
        }
        
        log.info("Email saved");
        return this.repository.save(email);
    }


}
