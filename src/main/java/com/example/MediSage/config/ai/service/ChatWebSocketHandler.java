package com.example.MediSage.config.ai.service;//package com.example.ChakriHub.config.ai.service;
//
//import com.example.ChakriHub.config.ai.service.OpenRouterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Component
//public class ChatWebSocketHandler extends TextWebSocketHandler {
//
//    @Autowired
//    private OpenRouterService openRouterService;
//
//    @Override
//    public void handleTextMessage(WebSocketSession session, TextMessage message) {
//        String userMessage = message.getPayload();
//        String response = openRouterService.getChatCompletion(userMessage);
//
//        try {
//            session.sendMessage(new TextMessage(response));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
