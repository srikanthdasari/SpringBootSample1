package com.sample2SpringBoot.Dao;

import com.sample2SpringBoot.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("InMemory")
public class StudentDaoImpl implements StudentDao {
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

    @Override
    public Collection<Student> getAllStudents(){
        return  this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student _student = this.students.get(student.getId());
        _student.setFirstName(student.getFirstName());
        _student.setLastName(student.getLastName());

        this.students.put(student.getId(), _student);
    }

    @Override
    public void insertStudent(Student student) {
        this.students.put(student.getId(),student);
    }
}
