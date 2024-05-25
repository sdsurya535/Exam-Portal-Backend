package com.exam.repo;

import com.exam.models.exam.Category;
import com.exam.models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz,Long> {
    List<Quiz> findBycategory(Category category);

    List<Quiz> findByActive(boolean active);

    List<Quiz> findByCategoryAndActive(Category c, boolean active);
}
