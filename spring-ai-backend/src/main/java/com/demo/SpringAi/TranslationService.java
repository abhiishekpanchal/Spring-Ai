package com.demo.SpringAi;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {

    private final OllamaChatModel chatModel;

    public TranslationService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String translate(String text, String sourceLang, String targetLang) {
        String promptText = String.format(
                "Translate the following text from %s to %s:\n\n%s",
                sourceLang, targetLang, text
        );

        Prompt prompt = new Prompt(promptText);

        ChatResponse response = chatModel.call(prompt);
        return response.getResult().getOutput().toString().trim();
    }
}
