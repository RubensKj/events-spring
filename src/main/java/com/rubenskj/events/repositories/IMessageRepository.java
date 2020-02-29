package com.rubenskj.events.repositories;

import com.rubenskj.events.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends MongoRepository<Message, String> {
}
