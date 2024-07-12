package com.example.UberClientWebSocket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RideResponseDto {
    private Long passengerId;
    private Long bookingId;

    @Override
    public String toString() {
        return "RideResponseDto{" +
                "passengerId=" + passengerId +
                ", bookingId=" + bookingId +
                '}';
    }
}
