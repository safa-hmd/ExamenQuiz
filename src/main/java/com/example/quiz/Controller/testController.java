package com.example.quiz.Controller;

import com.example.quiz.Entity.Candidat;
import com.example.quiz.Entity.Niveau;
import com.example.quiz.Entity.Question;
import com.example.quiz.Entity.Quiz;
import com.example.quiz.ServiceInterface.Iservice;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//injection de dependances
@AllArgsConstructor
@RequestMapping("/test")
public class testController {
    Iservice iservice;

    @PostMapping("/addCondidat")
    public Candidat ajouterCandidat(@RequestBody Candidat candidat) {
        return iservice.ajouterCandidat(candidat);
    }

    @PostMapping("/addQuiz")
    public Quiz ajouterQuiz(@RequestBody Quiz quiz) {
        return iservice.ajouterQuiz(quiz);
    }

    @PutMapping("/affecter/{titreQuiz}/{idCandidat}")
    public Quiz affecterQuizCandidat(@PathVariable String titreQuiz, @PathVariable Integer idCandidat) {
        return iservice.affecterQuizCandidat(titreQuiz, idCandidat);
    }

    @GetMapping("/candidats/recherche")
    public List<Candidat> recupererCandidat(@RequestParam String specialite,@RequestParam Niveau niveau) {
        return iservice.recupererCandidat(specialite, niveau);
    }

    @PostMapping("/questions/quiz/{idQuiz}")
    public Question ajouterQuestEtRepEtAffecterQuestAQuiz(@RequestBody Question question, @PathVariable Integer idQuiz) {
        return iservice.ajouterQuestEtRepEtAffecterQuestAQuiz(question, idQuiz);
    }

    @GetMapping("/plusDifficile")
    public String recupererQuizPlusDifficile() {
        iservice.recupererQuizPlusDifficile();
        return "Vérifiez la console pour voir le résultat";
    }
}
