package com.antonfifindik.botservice.repository;

import com.antonfifindik.botservice.model.db.Bot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BotRepository extends JpaRepository<Bot, UUID> {

    List<Bot> findAllByClientId(UUID clientId);

    void deleteAllByClientId(UUID clientId);
}
