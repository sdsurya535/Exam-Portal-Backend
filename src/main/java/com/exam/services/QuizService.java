package com.exam.services;

import com.exam.models.exam.Category;
import com.exam.models.exam.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Quiz getQuiz(Long qId);

    public Set<Quiz> getAllQuizes();

    public void deleteQuiz(Long qId);

    List<Quiz> getQuizzesByCategory(Category category);

    List<Quiz> getActiveQuizzes();

    List<Quiz> getActiveQuizzesOfCategory(Category category);
}
