package com.exam.services;

import com.exam.models.exam.Questions;
import com.exam.models.exam.Quiz;

import java.util.Set;

public interface QuestionsService {

    public Questions addQuestion(Questions question);

    public Questions updateQuestion(Questions question);


    public  Questions getQuestion(Long quesId);


    public Set<Questions> getAllQuestions();

    public Set<Questions> getQuestionOfQuiz(Quiz quiz);

    public void deleteQuestion(Long quesId);

    public Questions get(long quesId);
}
