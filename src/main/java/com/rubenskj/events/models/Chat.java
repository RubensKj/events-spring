package com.rubenskj.events.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Chat {

    @Id
    private String id;

    private List<Message> messages;

    public Chat() {
    }

    public Chat(List<Message> messages) {
        this.messages = messages;
    }

    public String getId() {
        return id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
