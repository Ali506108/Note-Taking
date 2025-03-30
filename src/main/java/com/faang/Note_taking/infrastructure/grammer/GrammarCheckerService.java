package com.faang.Note_taking.infrastructure.grammer;

import org.languagetool.language.BritishEnglish;
import org.springframework.stereotype.Component;
import org.languagetool.JLanguageTool;
import org.languagetool.language.LanguageBuilder;
import org.languagetool.rules.RuleMatch;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GrammarCheckerService {

    private final JLanguageTool langTool;

    public GrammarCheckerService() {
        this.langTool = new JLanguageTool(new BritishEnglish());
    }

    public String checkGrammar(String markdownContent) {
        try{

            String plainText = stripMarkdown(markdownContent);
            List<RuleMatch> matches = langTool.check(plainText);
            if (matches.isEmpty()) {
                return "No grammatical errors found.";
            }

            return matches.stream()
                    .map(match -> String.format("Potential error at line %d, column %d: %s. Suggested correction: %s",
                            match.getLine(), match.getColumn(), match.getMessage(), match.getSuggestedReplacements()))
                    .collect(Collectors.joining("\n"));

        }catch (IOException e) {
            return e.getMessage();
        }
    }

    private String stripMarkdown(String markdown) {
        return markdown.replaceAll("#+", "")
                .replaceAll("\\*+", "")
                .replaceAll("`+", "")
                .replaceAll("\\[.*?\\]\\(.*?\\)", "") // ссылки
                .replaceAll(">+", "")
                .replaceAll("!\\[.*?\\]\\(.*?\\)", "") // изображения
                .replaceAll("[-*_]{3,}", "")
                .replaceAll("```[\\s\\S]*?```", "") // code blocks
                .trim();
    }

}
