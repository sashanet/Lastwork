package ua.com.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Question;

public interface QuestionDao extends JpaRepository<Question, Integer> {


}
