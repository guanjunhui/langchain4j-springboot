package com.guan.langchainspringbootchat.config;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.QwenStreamingChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DashCodeChatConfig {

    @Autowired
    ChatModelConfig chatModelConfig;
    @Bean("myDashChatModel")
    public QwenChatModel initQwenChatModel(){
        return QwenChatModel.builder()
                .apiKey(chatModelConfig.getApiKey())
                .modelName(chatModelConfig.getModelName())
                .temperature(chatModelConfig.getTemperature())
                .enableSearch(chatModelConfig.getEnableSearch())
                .build();
    }

    @Bean("myStreamDashChatModel")
    public StreamingChatModel initStreamingQwenChatModel(){
        return QwenStreamingChatModel.builder()
                .apiKey(chatModelConfig.getApiKey())
                .modelName(chatModelConfig.getModelName())
                .temperature(chatModelConfig.getTemperature())
                .enableSearch(chatModelConfig.getEnableSearch())
                .build();
    }

}
