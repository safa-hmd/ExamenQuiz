package com.example.quiz.ServiceImpl;

import com.example.quiz.Entity.*;
import com.example.quiz.Repository.CandidatRepository;
import com.example.quiz.Repository.QuestionRepository;
import com.example.quiz.Repository.QuizRepository;
import com.example.quiz.Repository.ReponseRepository;
import com.example.quiz.ServiceInterface.Iservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class implService implements Iservice {

    CandidatRepository candidatRepository;
    QuizRepository quizRepository;
    QuestionRepository questionRepository;
    ReponseRepository reponseRepository;

    @Override
    public Candidat ajouterCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    @Override
    public Quiz ajouterQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz affecterQuizCandidat(String titreQuiz, Integer idCandidat) {
        Candidat c = candidatRepository.findById(idCandidat).orElse(null);
        Quiz q = quizRepository.findByTitreQuiz(titreQuiz);

        q.getCandidats().add(c);
        assert c != null;
        c.setNbQuiz(c.getNbQuiz() + 1);
        candidatRepository.save(c);

        return quizRepository.save(q);
    }

    @Override
    public List<Candidat> recupererCandidat(String specialite, Niveau niveau) {
        return candidatRepository.findByNiveauAndQuizsSpecialite(niveau, specialite);
    }

    @Override
    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(Question question, Integer idQuiz) {

        Quiz quiz = quizRepository.findById(idQuiz).orElse(null);
        // affecter le quiz à la question
        question.setQuiz(quiz);
        // sauvegarder la question
        Question q = questionRepository.save(question);
        // sauvegarder les réponses si elles existent
        if (question.getReponses() != null) {
            for (Reponse reponse : question.getReponses()) {
                reponseRepository.save(reponse);
            }
        }

        return q;
    }


}
