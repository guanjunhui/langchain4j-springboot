package com.guan.langchainspringbootchat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "langchain.community.dashcode")
public class ChatModelConfig {

    private String apiKey;
    private String modelName;
    private Float temperature;
    private Boolean enableSearch;
    private String maxTokens;

}
