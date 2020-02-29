package com.rubenskj.events.controllers;

import com.rubenskj.events.dtos.ChatDTO;
import com.rubenskj.events.dtos.MessageDTO;
import com.rubenskj.events.services.ChatService;
import com.rubenskj.events.services.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;
    private final ChatService chatService;

    public MessageController(MessageService messageService, ChatService chatService) {
        this.messageService = messageService;
        this.chatService = chatService;
    }

    @PostMapping("/chat/{chatId}/message")
    public ChatDTO createMessageInChatByGet(@PathVariable("chatId") String chatId, @Valid @RequestBody MessageDTO messageDTO) {
        return ChatDTO.of(this.messageService.createMessageInChat(this.chatService.findById(chatId), messageDTO));
    }
}
