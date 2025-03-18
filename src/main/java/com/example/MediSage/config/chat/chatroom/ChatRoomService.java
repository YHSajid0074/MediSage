package com.example.MediSage.config.chat.chatroom;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomService {

    private final ChatRoomRepo chatRoomRepo;

    public ChatRoomService(ChatRoomRepo chatRoomRepo){
        this.chatRoomRepo=chatRoomRepo;
    }

    public Optional<String>  getChatRoomId(
            String senderId,
            String recipientId,
            boolean createNewRoomIfNotExists
    ) {
        return chatRoomRepo
                .findBySenderIdAndRecipientId(senderId, recipientId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if(createNewRoomIfNotExists) {
                        var chatId = createChatId(senderId, recipientId);
                        return Optional.of(chatId);
                    }
                    return  Optional.empty();
                });
    }

    private String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId);

        ChatRoom senderRecipient = new ChatRoom();
        senderRecipient.setChatId(chatId);
        senderRecipient.setSenderId(senderId);
        senderRecipient.setRecipientId(recipientId);

        ChatRoom recipientSender = new ChatRoom();
        recipientSender.setChatId(chatId);
        recipientSender.setSenderId(recipientId);
        recipientSender.setRecipientId(senderId);


        chatRoomRepo.save(senderRecipient);
        chatRoomRepo.save(recipientSender);

        return chatId;
    }
}
