package com.faang.Note_taking.domain.service;

import com.faang.Note_taking.domain.model.Note;

import java.time.LocalDateTime;
import java.util.List;

public interface NoteService {

    Note saveNote(String title, String content);
    String checkNote(String markdownContent);
    List<Note> getAllNotes();
    String renderToHtml(String markdownContent);


}
