package com.bullish.student.controller;

import com.bullish.student.dao.StudDaoInterface;
import com.bullish.student.studentAttributes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class StudController {
    @Autowired
    private StudDaoInterface studentDao;

    @GetMapping("/student")
    public List<Student> getStudents(@RequestParam Map<String, String> dataQuery) {
        return studentDao.findStudent(dataQuery);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentDao.createStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {
        if(student != null && student.getId() > 0) {
            return studentDao.updateStudent(student);
        }
        return studentDao.updateStudent(student);
    }

    @DeleteMapping("/student")
    public void deleteStudent(@RequestBody Student student) {
        studentDao.deleteStudent(student.getId());
    }

}
