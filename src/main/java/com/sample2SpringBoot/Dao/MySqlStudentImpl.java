package com.sample2SpringBoot.Dao;

import com.sample2SpringBoot.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysql")
public class MySqlStudentImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("firstName"));
            student.setLastName(resultSet.getString("lastName"));
            return student;
        }
    }

    @Override
    public Collection<Student> getAllStudents() {
        final String sql ="SELECT id,firstName,lastName from students";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT id, firstName, lastName FROM students where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(),id);
        return student;
    }

    @Override
    public void removeStudentById(int id) {
        // DELETE FROM table_name
        // WHERE some_column = some_value
        final String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateStudent(Student student) {
        // UPDATE table_name
        // SET column1=value, column2=value2,...
        // WHERE some_column=some_value
        final String sql = "UPDATE students SET firstName = ?, lastName = ? WHERE id = ?";
        final int id = student.getId();
        final String firstName = student.getFirstName();
        final String lastName = student.getLastName();
        jdbcTemplate.update(sql, new Object[]{firstName, lastName, id});
    }

    @Override
    public void insertStudent(Student student) {
        // INSERT INTO table_name (column1, column2, column3,...)
        // VALUES (value1, value2, value3,...)
        final String sql = "INSERT INTO students (firstName, lastName) VALUES (?, ?)";
        final String firstName = student.getFirstName();
        final String lastName = student.getLastName();
        jdbcTemplate.update(sql, new Object[]{firstName, lastName});
    }
}
