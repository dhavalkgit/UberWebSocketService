package com.example.UberClientWebSocket.controller;

import com.example.UberClientWebSocket.dto.TestRequest;
import com.example.UberClientWebSocket.dto.TestResponce;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ClientSocketController {

    @MessageMapping("/ping")
    @SendTo("/topic/message")
    public TestResponce testConnection(TestRequest req){
        System.out.println("method is called");
        return TestResponce.builder()
                .data("received")
                .build();
    }
}
