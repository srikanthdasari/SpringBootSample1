package com.sample2SpringBoot.Service;

import com.sample2SpringBoot.Dao.StudentDao;
import com.sample2SpringBoot.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    @Qualifier("mysql")
    private StudentDao studentDao;

    public Collection<Student> getAllStudents() {
        return  this.studentDao.getAllStudents();
    }

    public  Student getStudentById(int id) {
        return this.studentDao.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }

    public  void updateStudent(Student student) {
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudent(student);
    }
}
