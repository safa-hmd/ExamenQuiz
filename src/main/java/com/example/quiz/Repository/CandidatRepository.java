package com.example.quiz.Repository;

import com.example.quiz.Entity.Candidat;
import com.example.quiz.Entity.Niveau;
import com.example.quiz.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat,Integer> {

    List<Candidat> findByNiveauAndQuizsSpecialite(Niveau niveau, String specialite);

}
