package com.example.MediSage.config.chat.chatting;

import com.example.MediSage.config.chat.chatroom.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageService {

    private  ChatMessageRepo chatMessageRepo;
    private ChatRoomService chatRoomService;

    public ChatMessageService(ChatMessageRepo chatMessageRepo, ChatRoomService chatRoomService) {
        this.chatMessageRepo = chatMessageRepo;
        this.chatRoomService = chatRoomService;
    }

    public ChatMessage save(ChatMessage chatMessage) {
        var chatId = chatRoomService
                .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow();
        chatMessage.setChatId(chatId);
        chatMessageRepo.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(chatMessageRepo::findByChatId).orElse(new ArrayList<>());
    }

}
