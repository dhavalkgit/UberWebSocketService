package com.example.UberClientWebSocket.controller;

import com.example.UberClientWebSocket.SocketService.DriverSocketService;
import com.example.UberClientWebSocket.dto.RideReqDto;
import com.example.UberClientWebSocket.dto.RideResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socket/driver")
public class DriverRequestController {

    private final DriverSocketService driverSocketService;

    public DriverRequestController(DriverSocketService driverSocketService) {
        this.driverSocketService = driverSocketService;
    }

    @PostMapping("/newride")
    public ResponseEntity<?> rideRequest(@RequestBody RideReqDto reqDto){
        driverSocketService.sendRideRequest(reqDto);
        return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
    }

    @MessageMapping("/ride/{driverId}")
    public void rideResponse(@DestinationVariable Long driverId, RideResponseDto reqDto){
        System.out.println(reqDto.toString());
    }
}
