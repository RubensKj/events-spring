package com.rubenskj.events.events;

import com.rubenskj.events.eventconfiguration.Event;
import com.rubenskj.events.models.Chat;
import com.rubenskj.events.models.Message;

public class MessageReceivedEvent extends Event {

    private Chat chat;
    private Message message;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public MessageReceivedEvent(Object source, Chat chat, Message message) {
        super(source);
        this.chat = chat;
        this.message = message;
    }

    public Chat getChat() {
        return chat;
    }

    public Message getMessage() {
        return message;
    }
}
