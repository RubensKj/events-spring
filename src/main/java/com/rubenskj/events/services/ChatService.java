package com.rubenskj.events.services;

import com.rubenskj.events.dtos.ChatDTO;
import com.rubenskj.events.exceptions.ChatNotFoundException;
import com.rubenskj.events.models.Chat;
import com.rubenskj.events.repositories.IChatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ChatService {

    private final IChatRepository iChatRepository;

    public ChatService(IChatRepository iChatRepository) {
        this.iChatRepository = iChatRepository;
    }

    public Chat save(ChatDTO chatDTO) {
        return this.iChatRepository.save(new Chat(new ArrayList<>()));
    }

    public Chat findById(String chatId) {
        return this.iChatRepository.findById(chatId).orElseThrow(() -> new ChatNotFoundException("Chat wasn't found, please verify the id."));
    }
}
