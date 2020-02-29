package com.rubenskj.events.controllers;

import com.rubenskj.events.dtos.ChatDTO;
import com.rubenskj.events.services.ChatService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ChatDTO createChat(@Valid @RequestBody ChatDTO chatDTO) {
        return ChatDTO.of(this.chatService.save(chatDTO));
    }

    @GetMapping("/chat/{chatId}")
    public ChatDTO getChatById(@PathVariable("chatId") String chatId) {
        return ChatDTO.of(this.chatService.findById(chatId));
    }
}
