package com.faang.Note_taking.application.note;

import com.faang.Note_taking.domain.model.Note;
import com.faang.Note_taking.domain.repository.NoteRepository;
import com.faang.Note_taking.domain.service.NoteService;
import com.faang.Note_taking.infrastructure.grammer.GrammarCheckerService;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class NoteUseCase implements NoteService {

    private final NoteRepository repository;
    private final GrammarCheckerService grammarChecker;

    public NoteUseCase(NoteRepository repository
                       , GrammarCheckerService grammarChecker) {
        this.repository = repository;
        this.grammarChecker = grammarChecker;
    }

    @Override
    public Note saveNote(String title, String content) {
        return repository.save(new Note(null ,title , content , LocalDateTime.now()));
    }

    @Override
    public String checkNote(String markdownContent) {
        return grammarChecker.checkGrammar(markdownContent);
    }

    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public String renderToHtml(String markdownContent) {
        return HtmlRenderer.builder().build()
                .render(Parser.builder().build().parse(markdownContent));
    }
}
