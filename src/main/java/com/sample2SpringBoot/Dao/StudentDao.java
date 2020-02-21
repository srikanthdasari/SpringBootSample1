package com.sample2SpringBoot.Dao;

import com.sample2SpringBoot.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {
    public static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1,"TestFirst1","TestLast1"));
                put(2, new Student(2,"TestFirst2","TestLast2"));
                put(3, new Student(3,"TestFirst3","TestLast3"));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return  this.students.values();
    }

    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student student) {
        Student _student = this.students.get(student.getId());
        _student.setFirstName(student.getFirstName());
        _student.setLastName(student.getLastName());

        this.students.put(student.getId(), _student);
    }

    public void insertStudent(Student student) {
        this.students.put(student.getId(),student);
    }
}
