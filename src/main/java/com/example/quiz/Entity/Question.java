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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idQuestion;
    String libelleQ;

    @Enumerated(EnumType.STRING)
    Complexite complexite;

    @ManyToOne
    Quiz quiz;

    @OneToMany( cascade = CascadeType.ALL)
    List<Reponse> reponses;
}
