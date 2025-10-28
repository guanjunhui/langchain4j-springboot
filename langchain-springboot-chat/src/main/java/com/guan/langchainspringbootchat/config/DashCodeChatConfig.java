package com.guan.langchainspringbootchat.config;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DashCodeChatConfig {

    @Autowired
    ChatModelConfig chatModelConfig;
    @Bean
    public QwenChatModel initQwenChatModel(){
        return QwenChatModel.builder()
                .apiKey(chatModelConfig.getApiKey())
                .modelName(chatModelConfig.getModelName())
                .temperature(chatModelConfig.getTemperature())
                .enableSearch(chatModelConfig.getEnableSearch())
                .build();
    }

}
