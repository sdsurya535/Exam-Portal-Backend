package com.exam.repo;

import com.exam.models.exam.Questions;
import com.exam.models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionsRepo extends JpaRepository<Questions,Long> {

    Set<Questions> findByQuiz(Quiz quiz);
}
