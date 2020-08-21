package com.apimongodb.Model;

import lombok.*;



public class Student {

    private  int id;
    private String firstName;
    private String lastName;
    private String admissonNumber;
    private int age;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAdmissonNumber(String admissonNumber) {
        this.admissonNumber = admissonNumber;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getAdmissonNumber() {
        return admissonNumber;
    }

    public int getAge() {
        return age;
    }

    public Student(int id, String firstName, String lastName, String admissonNumber, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admissonNumber = admissonNumber;
        this.age = age;
    }


}
