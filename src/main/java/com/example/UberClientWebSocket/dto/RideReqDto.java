package com.example.UberClientWebSocket.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RideReqDto {
    private Long passengerId;
    private List<Long> driverId;
    private Long bookingId;
}
