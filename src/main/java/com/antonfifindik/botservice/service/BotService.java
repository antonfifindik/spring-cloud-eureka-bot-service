package com.antonfifindik.botservice.service;

import com.antonfifindik.botservice.model.db.Bot;
import com.antonfifindik.botservice.repository.BotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BotService {

    private BotRepository botRepository;

    public List<Bot> findAll() {
        return botRepository.findAll();
    }

    public List<Bot> findAllByClient(UUID clientId) {
        return botRepository.findAllByClientId(clientId);
    }

    public Bot getOne(UUID id) {
       return botRepository.getOne(id);
    }

    public void saveAndFlush(Bot bot) {
        botRepository.saveAndFlush(bot);
    }

    public Long count() {
        return botRepository.count();
    }

    public boolean existById(UUID id) {
        return botRepository.existsById(id);
    }

    public void deleteById(UUID id) {
        botRepository.deleteById(id);
    }

    public void delete(Bot bot) {
        botRepository.delete(bot);
    }

    public void deleteAll(List<Bot> bots) {
        botRepository.deleteAll(bots);
    }

    public void deleteAllByClientId(UUID clientId) {
        botRepository.deleteAllByClientId(clientId);
    }


    @Autowired
    public void setBotRepository(BotRepository botRepository) {
        this.botRepository = botRepository;
    }
}
