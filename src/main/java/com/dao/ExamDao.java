package com.dao;

import java.util.List;

import com.pojo.Exam;

public interface ExamDao {
   List<Exam> getExamsBySubject(int subject_id);
   Exam getExamById(int exam_id);
   boolean createdExam(Exam e);
   boolean updatedExam(Exam e);
   boolean deleteExam(int exam_id);
}
