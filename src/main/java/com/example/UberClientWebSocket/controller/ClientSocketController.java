package com.example.UberClientWebSocket.controller;

import com.example.UberClientWebSocket.dto.TestRequest;
import com.example.UberClientWebSocket.dto.TestResponce;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class ClientSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public ClientSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/ping")
    @SendTo("/topic/message")
    public TestResponce testConnection(TestRequest req){
        System.out.println("method is called");
        return TestResponce.builder()
                .data("received")
                .build();
    }

//    @Scheduled(fixedDelay = 2000)
//    public void sendResponce(){
//        simpMessagingTemplate.convertAndSend("/topic/scheduled","Hi you received message");
//    }
}
