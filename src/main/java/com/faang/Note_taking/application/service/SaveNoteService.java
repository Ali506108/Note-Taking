package com.faang.Note_taking.application.service;


import com.faang.Note_taking.domain.model.Note;
import com.faang.Note_taking.domain.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SaveNoteService {



    private final NoteRepository repository;

    public SaveNoteService(NoteRepository repository) {
        this.repository = repository;
    }


    public void save(String title , String content) {
        long id = new Random().nextLong();
        Note note = new Note(id , title , content);
        repository.save(note);
    }

}
