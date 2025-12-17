package com.example.quiz.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idReponse;
    String libelleR;

}
