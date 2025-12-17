package com.example.quiz.ServiceInterface;

import com.example.quiz.Entity.Candidat;
import com.example.quiz.Entity.Niveau;
import com.example.quiz.Entity.Question;
import com.example.quiz.Entity.Quiz;

import java.util.List;

public interface Iservice {
    public Candidat ajouterCandidat(Candidat candidat) ;
    public Quiz ajouterQuiz(Quiz quiz) ;

    public Quiz affecterQuizCandidat(String titreQuiz, Integer idCandidat) ;

    public List<Candidat> recupererCandidat (String specialite, Niveau niveau) ;

    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(Question question,Integer idQuiz) ;

    public void recupererQuizPlusDifficile() ;
}
