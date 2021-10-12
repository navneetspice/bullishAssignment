package com.bullish.student.dao.impl;

import com.bullish.student.dao.StudDaoInterface;
import com.bullish.student.studentAttributes.Student;
import com.bullish.student.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class StudDao implements StudDaoInterface {

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentsRepository.createStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
         studentsRepository.deleteStudent(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentsRepository.updateStudent(student);
    }

    @Override
    public List<Student> findStudentByID(int id){
        return studentsRepository.findById(id);
    }

    @Override
    public List<Student> findStudentByClass(String stud_class){
        return studentsRepository.findByClass(stud_class);
    }

    public List<Student> findStudent(Map<String, String> dataQuery){
        return studentsRepository.findStudent(dataQuery);
    }



}
