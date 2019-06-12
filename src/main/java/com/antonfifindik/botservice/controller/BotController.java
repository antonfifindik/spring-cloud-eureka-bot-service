package com.antonfifindik.botservice.controller;

import com.antonfifindik.botservice.model.db.Bot;
import com.antonfifindik.botservice.service.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/bots")
public class BotController {

    private BotService botService;

    @GetMapping(value = "/")
    public List<Bot> getAllBots() {
        return botService.findAll();
    }

    @GetMapping(value = "/client/{clientId}")
    public List<Bot> getAllBotsByClientId(@PathVariable UUID clientId) {
        return botService.findAllByClient(clientId);
    }

    @GetMapping(value = "/{botId}")
    public Bot getOne(@PathVariable UUID botId) {
        return botService.getOne(botId);
    }

    @PostMapping(value = "/")
    public void save(@RequestBody Bot bot) {
        botService.saveAndFlush(bot);
    }

    @GetMapping(value = "/count")
    public Long count() {
        return botService.count();
    }

    @GetMapping(value = "/exist/{botId}")
    public boolean exist(@PathVariable UUID botId) {
        return botService.existById(botId);
    }

    @DeleteMapping(value = "/{botId}")
    public void deleteById(@PathVariable UUID botId) {
        botService.deleteById(botId);
    }

    @DeleteMapping(value = "/")
    public void delete(@RequestBody Bot bot) {
        botService.delete(bot);
    }

    @DeleteMapping(value = "/all")
    public void deleteAll(@RequestBody List<Bot> bots) {
        botService.deleteAll(bots);
    }

    @DeleteMapping(value = "/client/{clientId}")
    public void deleteAllByClientId(@PathVariable UUID clientId) {
        botService.deleteAllByClientId(clientId);
    }

    @Autowired
    public void setBotService(BotService botService) {
        this.botService = botService;
    }
}
