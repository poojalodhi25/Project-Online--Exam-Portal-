package com.dao;

import java.util.List;

import com.pojo.ExamResult;

public interface ExamResultDao {
   boolean saveExamResult(ExamResult r);
   ExamResult getExamResult(int exam_id , int user_id);
   List<ExamResult> getExamResultsByUser(int user_id);
}
