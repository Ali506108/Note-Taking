package com.faang.Note_taking.api.controller;

import com.faang.Note_taking.domain.model.Note;
import com.faang.Note_taking.domain.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/check-grammar")
    public ResponseEntity<String> checkGrammar(@RequestBody String content) {
        return ResponseEntity.ok(noteService.checkNote(content));
    }

    @PostMapping
    public ResponseEntity<Note> saveNote(@RequestParam String title, @RequestBody String markdown) {
        return ResponseEntity.ok(noteService.saveNote(title, markdown));
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @PostMapping("/render")
    public ResponseEntity<String> renderMarkdown(@RequestBody String markdown) {
        return ResponseEntity.ok(noteService.renderToHtml(markdown));
    }
}
