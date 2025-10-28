package com.guan.langchainspringbootchat.controller;

import com.guan.langchainspringbootchat.aiservice.Assistant;
import com.guan.langchainspringbootchat.aiservice.StreamingAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private QwenChatModel qwenChatModel;
    @Autowired
    Assistant assistant;
    @Autowired
    private StreamingAssistant streamingAssistant;

    @GetMapping("/v1")
    public String model(@RequestParam(value = "message", defaultValue = "Hello") String message) {
        UserMessage userMessage = UserMessage.from(message);
        ChatResponse chatResponse = qwenChatModel.chat(userMessage);
        return chatResponse.aiMessage().text();
    }

    @GetMapping("/v2")
    public String model2(@RequestParam(value = "message", defaultValue = "Hello") String message) {
        return assistant.chat(message);
    }


    @GetMapping("/v3")
    public Flux<String> model3(@RequestParam(value = "message", defaultValue = "Hello") String message) {
        return streamingAssistant.chat(message);
    }

}
