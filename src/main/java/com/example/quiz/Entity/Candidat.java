package com.example.quiz.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCandidat;
    String nom;
    String prenom;
    int nbQuiz;

    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @ManyToMany(mappedBy = "candidats")
    List<Quiz> quizs;


}
