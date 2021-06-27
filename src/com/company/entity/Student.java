package com.company.entity;

public class Student {
    private String surname;
    private String name;
    private String patronymic;
    private String city;
    private boolean IsStudentStudying;

    public Student(String surname, String name, String patronymic, String city) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.city = city;
    }

    public boolean isStudying() {
        return IsStudentStudying;
    }

    public void setStudying(boolean studying) {
        IsStudentStudying = studying;
    }

    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getPatronymic() {
        return patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
