package com.cassianodess.ms.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.cassianodess.ms.DTO.EmailDTO;
import com.cassianodess.ms.services.EmailService;

@Component
public class EmailConsumer {
    
    @Autowired
    private EmailService service;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDTO) {
        service.sendEmail(emailDTO);
    }

}
