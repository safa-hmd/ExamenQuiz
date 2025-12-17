package com.example.quiz.Repository;

import com.example.quiz.Entity.Quiz;
import com.example.quiz.Entity.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Integer> {
}
