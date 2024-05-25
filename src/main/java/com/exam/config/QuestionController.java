package com.exam.config;

import com.exam.models.exam.Questions;
import com.exam.models.exam.Quiz;
import com.exam.services.QuestionsService;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Questions> addQuestion(@RequestBody Questions questions) {
        Questions questions1 = this.questionsService.addQuestion(questions);
        return ResponseEntity.ok(questions1);
    }

    @PutMapping("/")
    public ResponseEntity<Questions> updateQuestion(@RequestBody Questions questions) {
        return ResponseEntity.ok(this.questionsService.updateQuestion(questions));
    }

    @GetMapping("/quiz/{qId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qId") Long qId) {

        Quiz quiz = this.quizService.getQuiz(qId);
        Set<Questions> questions = quiz.getQuestions();
        List list = new ArrayList<>(questions);
        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {

            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));

        }

        questions.forEach(q -> {
            q.setAnswer("");
        });
        Collections.shuffle(list);

        return ResponseEntity.ok(list);


    }

    @GetMapping("/quiz/all/{qId}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qId") Long qId) {

        Quiz quiz = new Quiz();
        quiz.setQId(qId);
        Set<Questions> questions = this.questionsService.getQuestionOfQuiz(quiz);

        return ResponseEntity.ok(questions);


    }

    @GetMapping("/{quesId}")
    public Questions getQuestionById(@PathVariable("quesId") Long quesId) {
        return this.questionsService.getQuestion(quesId);
    }

    @DeleteMapping("/{quesId}")
    public void deleteQuestion(@PathVariable("quesId") Long quesId) {

        this.questionsService.deleteQuestion(quesId);
    }

    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Questions> questions) {
        double marksGot = 0;
        int correctAnswer = 0;
        int attempted = 0;
        for (Questions q : questions) {

            Questions questions1 = this.questionsService.get(q.getQuesId());
            if (questions1.getAnswer().equals(q.getGivenAnswer())) {

                correctAnswer++;

                double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
                marksGot += marksSingle;

            }

            if( q.getGivenAnswer()!= null){
                    attempted++;
            }

        }

        Map<String, Object> of = Map.of("marksGot",marksGot,"correctAnswer",correctAnswer,"attempted",attempted);

        return ResponseEntity.ok(of);
    }
}
