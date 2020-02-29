package com.rubenskj.events.listeners;

import com.rubenskj.events.eventconfiguration.ListenerAdapter;
import com.rubenskj.events.events.MessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class MessageReceivedEventListener implements ListenerAdapter<MessageReceivedEvent> {
    @Override
    public void execute(MessageReceivedEvent event) {
        System.out.println("execute works");
        System.out.println("RECEBENDO MENSAGEM - " + event.getMessage().getTextContent());
    }

    @Override
    public void onFinally(MessageReceivedEvent event) {
        System.out.println("Executed works");
    }
}
