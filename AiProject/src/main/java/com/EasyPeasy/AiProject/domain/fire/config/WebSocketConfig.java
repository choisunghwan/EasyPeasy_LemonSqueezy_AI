package com.EasyPeasy.AiProject.domain.fire.config;

/*Spring Boot 애플리케이션에서 WebSocket을 구성하는 데 사용되는 설정 클래스*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration  //해당 클래스가 Spring의 구성 클래스임을 나타냅니다. 이 클래스는 애플리케이션 컨텍스트를 설정하는 데 사용
@EnableWebSocket  // WebSocket을 사용할 수 있도록 Spring에게 알려줍니다.
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new FireDetectionHandler(), "/ws")
                .setAllowedOrigins("*");
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}

