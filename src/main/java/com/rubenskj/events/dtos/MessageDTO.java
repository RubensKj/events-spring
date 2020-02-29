package com.rubenskj.events.dtos;

import com.rubenskj.events.models.Message;

public class MessageDTO {

    private String id;
    private String user;
    private String textContent;

    public MessageDTO() {
    }

    public MessageDTO(String user, String textContent) {
        this.user = user;
        this.textContent = textContent;
    }

    public MessageDTO(String id, String user, String textContent) {
        this.id = id;
        this.user = user;
        this.textContent = textContent;
    }

    public static MessageDTO of(Message message) {
        return new MessageDTO(message.getId(),
                message.getUser(),
                message.getTextContent());
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getTextContent() {
        return textContent;
    }
}
