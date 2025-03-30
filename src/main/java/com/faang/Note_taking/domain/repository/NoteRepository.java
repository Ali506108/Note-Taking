package com.faang.Note_taking.domain.repository;

import com.faang.Note_taking.domain.model.Note;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository {

    void save(Note note);
    Optional<Note> findById(long id);
    List<Note> findAll();
}
