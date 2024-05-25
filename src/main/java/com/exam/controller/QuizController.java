package com.exam.controller;

import com.exam.models.exam.Category;
import com.exam.models.exam.Quiz;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        Quiz quiz1 = this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        Quiz quiz1 = this.quizService.updateQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllQuizzes(){
        return ResponseEntity.ok(this.quizService.getAllQuizes());
    }
    @GetMapping("/{qId}")
    public Quiz getQuizById(@PathVariable("qId") Long qId){
        return this.quizService.getQuiz(qId);
    }
    @DeleteMapping("/{qId}")
    public void deleteQuiz(@PathVariable("qId")Long qId){
        this.quizService.deleteQuiz(qId);
    }
    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizzesByCategory(@PathVariable("cid") Long cid){

        Category category = new Category();
        category.setCId(cid);
        return this.quizService.getQuizzesByCategory(category);

    }

    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes(){
        return  this.quizService.getActiveQuizzes();
    }
    @GetMapping("/active/{cid}")
    public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setCId(cid);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }
}
