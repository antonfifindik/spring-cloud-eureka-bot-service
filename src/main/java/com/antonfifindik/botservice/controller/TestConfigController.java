package com.antonfifindik.botservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/message")
public class TestConfigController {

    @Value("${config.test.message: Config server is not working.. =\\}")
    private String message;

    @Value("${common.config.test.message: Config server is not working.. =\\}")
    private String commonMessage;

    @GetMapping
    public String message() {
        return message;
    }

    @GetMapping("/common")
    public String commonMessage() {
        return commonMessage;
    }
}
