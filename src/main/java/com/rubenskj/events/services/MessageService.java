package com.rubenskj.events.services;

import com.rubenskj.events.dtos.MessageDTO;
import com.rubenskj.events.models.Chat;
import com.rubenskj.events.models.Message;
import com.rubenskj.events.publishers.MessageReceivedEventPublisher;
import com.rubenskj.events.repositories.IChatRepository;
import com.rubenskj.events.repositories.IMessageRepository;
import com.rubenskj.events.utils.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final IMessageRepository iMessageRepository;
    private final IChatRepository iChatRepository;
    private final MessageReceivedEventPublisher messageReceivedEventPublisher;

    public MessageService(IMessageRepository iMessageRepository, IChatRepository iChatRepository, MessageReceivedEventPublisher messageReceivedEventPublisher) {
        this.iMessageRepository = iMessageRepository;
        this.iChatRepository = iChatRepository;
        this.messageReceivedEventPublisher = messageReceivedEventPublisher;
    }

    public Message save(MessageDTO messageDTO) {
        this.validate(messageDTO);

        return this.iMessageRepository.save(new Message(messageDTO.getUser(), messageDTO.getTextContent()));
    }

    private void validate(MessageDTO messageDTO) {
        ValidationUtils.isEmptyString(messageDTO.getTextContent());
    }

    public Chat createMessageInChat(Chat chat, MessageDTO messageDTO) {
        Message message = this.save(messageDTO);

        this.putMessageInChat(chat, message);

        this.messageReceivedEventPublisher.publishMessageReceivedEvent(chat, message);

        return chat;
    }

    private void putMessageInChat(Chat chat, Message message) {
        chat.getMessages().add(message);
        this.iChatRepository.save(chat);
    }
}
