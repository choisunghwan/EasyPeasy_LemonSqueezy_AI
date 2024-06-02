package com.EasyPeasy.AiProject.domain.fire.config;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class FireDetectionHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // WebSocket 클라이언트로부터 메시지 수신 처리
        System.out.println("Received message: " + message.getPayload());

        // 클라이언트에게 응답 전송
        session.sendMessage(new TextMessage("서버에서 클라이언트로 Fire detected!"));
    }
}
