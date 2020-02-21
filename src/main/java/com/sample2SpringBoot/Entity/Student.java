package com.sample2SpringBoot.Entity;

public class Student {
    private int id;
    private String firstName;
    private String lastName;

    public Student(int _id, String _firstName,String _lastName) {
        this.id= _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
    }

    public Student() {}


    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
