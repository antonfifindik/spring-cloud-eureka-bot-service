package com.antonfifindik.botservice.model.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Bot {

    private UUID botId;
    private String name;
    private boolean isDeployed;
    private boolean isRun;
    private UUID clientId;

    public Bot() {
    }

    public Bot(UUID botId, String name, boolean isDeployed, boolean isRun, UUID clientId) {
        this.botId = botId;
        this.name = name;
        this.isDeployed = isDeployed;
        this.isRun = isRun;
        this.clientId = clientId;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "bot_id", updatable = false, nullable = false)
    @JsonProperty("bot_id")
    public UUID getBotId() {
        return botId;
    }

    public void setBotId(UUID botId) {
        this.botId = botId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("is_deployed")
    public boolean isDeployed() {
        return isDeployed;
    }

    public void setDeployed(boolean deployed) {
        isDeployed = deployed;
    }

    @JsonProperty("is_run")
    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    @JsonProperty("client_id")
    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bot bot = (Bot) o;
        return isDeployed == bot.isDeployed &&
                isRun == bot.isRun &&
                Objects.equals(botId, bot.botId) &&
                Objects.equals(name, bot.name) &&
                Objects.equals(clientId, bot.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(botId, name, isDeployed, isRun, clientId);
    }

    @Override
    public String toString() {
        return "Bot{" +
                "botId=" + botId +
                ", name='" + name + '\'' +
                ", isDeployed=" + isDeployed +
                ", isRun=" + isRun +
                ", clientId=" + clientId +
                '}';
    }
}
