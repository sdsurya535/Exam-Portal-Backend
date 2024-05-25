package com.exam.services.impl;

import com.exam.models.exam.Category;
import com.exam.models.exam.Quiz;
import com.exam.repo.QuizRepo;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Quiz getQuiz(Long qId) {
        return this.quizRepo.findById(qId).get();
    }

    @Override
    public Set<Quiz> getAllQuizes() {
        return new HashSet<>(this.quizRepo.findAll());
    }

    @Override
    public void deleteQuiz(Long qId) {

        Quiz quiz = new Quiz();
        quiz.setQId(qId);
        this.quizRepo.delete(quiz);

    }

    @Override
    public List<Quiz> getQuizzesByCategory(Category category) {
        return this.quizRepo.findBycategory(category);
    }

    @Override
    public List<Quiz> getActiveQuizzes() {
        return this.quizRepo.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category category) {
        return this.quizRepo.findByCategoryAndActive(category,true);
    }
}
