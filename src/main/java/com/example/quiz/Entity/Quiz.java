package com.example.quiz.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idQuiz;
    String titreQuiz;
    String specialite;
    LocalDateTime dateQuiz;

    @ManyToMany
    List<Candidat> candidats;

    @OneToMany(mappedBy = "quiz")
    List<Question> questions;
}
