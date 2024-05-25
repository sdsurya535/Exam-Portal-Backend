package com.exam.services.impl;

import com.exam.models.exam.Questions;
import com.exam.models.exam.Quiz;
import com.exam.repo.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class QuestionsServiceImpl implements com.exam.services.QuestionsService {

    @Autowired
    private QuestionsRepo questionsRepo;

    @Override
    public Questions addQuestion(Questions question) {
        return this.questionsRepo.save(question);
    }

    @Override
    public Questions updateQuestion(Questions question) {
        return this.questionsRepo.save(question);
    }

    @Override
    public Questions getQuestion(Long quesId) {
        return this.questionsRepo.findById(quesId).get();
    }

    @Override
    public Set<Questions> getAllQuestions() {
        return new HashSet<>(this.questionsRepo.findAll());
    }

    @Override
    public Set<Questions> getQuestionOfQuiz(Quiz quiz) {
        return this.questionsRepo.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        Questions questions = new Questions();
        questions.setQuesId(quesId);
        this.questionsRepo.delete(questions);
    }

    @Override
    public Questions get(long quesId) {
        return this.questionsRepo.getReferenceById(quesId);
    }
}
