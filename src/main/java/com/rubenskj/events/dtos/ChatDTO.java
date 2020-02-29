package com.rubenskj.events.dtos;

import com.rubenskj.events.models.Chat;
import com.rubenskj.events.utils.ChatUtils;

import java.util.List;

public class ChatDTO {

    private String id;
    private List<MessageDTO> messagesDTO;

    public ChatDTO() {
    }

    public ChatDTO(String id, List<MessageDTO> messagesDTO) {
        this.id = id;
        this.messagesDTO = messagesDTO;
    }

    public static ChatDTO of(Chat chat) {
        return new ChatDTO(chat.getId(),
                ChatUtils.parseMessagesToDTO(chat.getMessages()));
    }

    public String getId() {
        return id;
    }

    public List<MessageDTO> getMessagesDTO() {
        return messagesDTO;
    }
}
