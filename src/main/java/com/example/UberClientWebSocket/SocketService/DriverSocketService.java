package com.example.UberClientWebSocket.SocketService;

import com.example.UberClientWebSocket.dto.RideReqDto;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DriverSocketService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public DriverSocketService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendRideRequest(RideReqDto reqDto){
        //Ideally the request should only go to nearby drivers, but for simplicity we send it everyone
        simpMessagingTemplate.convertAndSend("/topic/rideRequest", reqDto);
    }
}
