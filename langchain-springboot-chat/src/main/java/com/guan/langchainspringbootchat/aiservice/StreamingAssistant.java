package com.guan.langchainspringbootchat.aiservice;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService(
        streamingChatModel = "myStreamDashChatModel"
)
public interface StreamingAssistant {

    @SystemMessage("【must】你是一个时间助手，只能处理时间相关的事情，其余问题不能给出回答，要给一个有好的提示！")
    Flux<String> chat(String userMessage);

}
