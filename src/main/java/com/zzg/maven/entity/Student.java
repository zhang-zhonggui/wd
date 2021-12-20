package com.zzg.maven.entity;

import java.io.Serializable;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private String address;
    private String grade;

    public Student() {
    }

    public Student(int id, String name, int age, String address, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
