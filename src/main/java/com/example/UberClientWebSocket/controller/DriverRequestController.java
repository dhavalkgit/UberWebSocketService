package com.example.UberClientWebSocket.controller;

import com.example.UberClientWebSocket.SocketService.DriverSocketService;
import com.example.UberClientWebSocket.dto.RideReqDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


}
