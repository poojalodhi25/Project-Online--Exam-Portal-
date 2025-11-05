package com.dao;

import java.util.List;

import com.pojo.Subject;

public interface SubjectDao {
    List<Subject>getAllSubject();
    Subject getSubjectById(int subject_id);
   boolean add_Subject(Subject s);
}
