package com.example.UberClientWebSocket.configuration;

import com.example.UberClientWebSocket.controller.WebSocketController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class ServerWebSocketConfig implements WebSocketConfigurer {

    /**
     * It uses to register websocket endpoints
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/test")
                .setAllowedOrigins("*");
    }

    @Bean
    public WebSocketController webSocketHandler(){
        return new WebSocketController();
    }
}
