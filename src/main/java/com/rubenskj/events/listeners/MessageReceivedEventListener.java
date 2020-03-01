package com.rubenskj.events.listeners;

import com.rubenskj.events.eventconfiguration.ListenerAdapter;
import com.rubenskj.events.events.MessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class MessageReceivedEventListener implements ListenerAdapter<MessageReceivedEvent> {

    @Override
    public void execute(MessageReceivedEvent event) throws Exception {
        System.out.println("This is a execution from MessageReceivedEvent");
        System.out.print(event.getMessage().getUser() + ": ");
        System.out.println(event.getMessage().getTextContent());
    }
}
