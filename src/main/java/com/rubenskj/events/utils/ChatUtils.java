package com.rubenskj.events.utils;

import com.rubenskj.events.dtos.MessageDTO;
import com.rubenskj.events.models.Message;

import java.util.List;
import java.util.stream.Collectors;

public class ChatUtils {
    public static List<MessageDTO> parseMessagesToDTO(List<Message> messages) {
        return messages.stream().map(message -> new MessageDTO(message.getId(), message.getUser(), message.getTextContent())).collect(Collectors.toList());
    }
}
