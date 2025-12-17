package com.example.quiz.Repository;

import com.example.quiz.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    Quiz findByTitreQuiz(String titreQuiz);

    @Query("""
        SELECT q
        FROM Quiz q
        JOIN q.questions qu
        WHERE qu.complexite = 'DIFFICILE'
        GROUP BY q
        ORDER BY COUNT(qu) DESC
    """)
    List<Quiz> findQuizPlusDifficile();
}
