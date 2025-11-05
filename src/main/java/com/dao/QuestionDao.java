package com.dao;

import java.util.List;

import com.pojo.Question;

public interface QuestionDao {
    List<Question> getQuestionsBySubject(int subject_id);
    Question getQuestionById(int que_id);
    boolean addQuetion(Question q);
    boolean updateQuestion(Question q);
    boolean deleteQuestion(int que_id);
}
