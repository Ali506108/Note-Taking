package com.faang.Note_taking.infrastructure.persistence;

import com.faang.Note_taking.domain.model.Note;
import com.faang.Note_taking.domain.repository.NoteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteJpaRepository extends JpaRepository<Note, Long>, NoteRepository {
}

