package com.demo.SpringAi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenAIController {

    private final ChatService chatService;
    private final RecipeService recipeService;
    private final TranslationService translationService;

    public GenAIController(ChatService chatService,
                           RecipeService recipeService,
                           TranslationService translationService) {
        this.chatService = chatService;
        this.recipeService = recipeService;
        this.translationService = translationService;
    }

    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("recipe-creator")
    public String recipeCreator(@RequestParam String ingredients,
                                @RequestParam(defaultValue = "any") String cuisine,
                                @RequestParam(defaultValue = "") String dietaryRestriction) {
        return recipeService.createRecipe(ingredients, cuisine, dietaryRestriction);
    }

    @GetMapping("translate")
    public String translate(@RequestParam String text,
                            @RequestParam(defaultValue = "English") String sourceLang,
                            @RequestParam(defaultValue = "Spanish") String targetLang) {
        return translationService.translate(text, sourceLang, targetLang);
    }
}
