package com.cassianodess.ms.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassianodess.ms.DTO.EmailDTO;
import com.cassianodess.ms.models.Email;
import com.cassianodess.ms.services.EmailService;

@RestController
@CrossOrigin
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping
    public ResponseEntity<Email> sendEmail(@RequestBody @Valid EmailDTO emailDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.sendEmail(emailDTO));
    } 
    
}
