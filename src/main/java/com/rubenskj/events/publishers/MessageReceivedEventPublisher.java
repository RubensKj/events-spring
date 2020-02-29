package com.rubenskj.events.publishers;

import com.rubenskj.events.events.MessageReceivedEvent;
import com.rubenskj.events.models.Chat;
import com.rubenskj.events.models.Message;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MessageReceivedEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public MessageReceivedEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishMessageReceivedEvent(Chat chat, Message message) {
        MessageReceivedEvent messageReceivedEvent = new MessageReceivedEvent(this, chat, message);
        this.applicationEventPublisher.publishEvent(messageReceivedEvent);
    }
}
