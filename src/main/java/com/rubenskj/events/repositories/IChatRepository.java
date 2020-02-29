package com.rubenskj.events.repositories;

import com.rubenskj.events.models.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChatRepository extends MongoRepository<Chat, String> {
}
