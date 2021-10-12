package com.bullish.student.dao;

import com.bullish.student.studentAttributes.Student;

import java.util.List;
import java.util.Map;

public interface StudDaoInterface {
    public List<Student> findAllStudents();
    public Student createStudent(Student student);
    public void deleteStudent(int id);
    public Student updateStudent(Student student);
    public List<Student> findStudentByID(int id);
    public List<Student> findStudentByClass(String stud_class);
    public List<Student> findStudent(Map<String, String> dataQuery);


}
