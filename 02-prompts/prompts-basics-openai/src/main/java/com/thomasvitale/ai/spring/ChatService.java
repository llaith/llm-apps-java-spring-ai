package com.thomasvitale.ai.spring;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
class ChatService {

    private final ChatClient chatClient;

    ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    String chatWithText(String message) {
        return chatClient.prompt().user(message).call().content();
    }

    ChatResponse chatWithPrompt(String message) {
        return chatClient.prompt(new Prompt(message)).call().chatResponse();
    }

}
