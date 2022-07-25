package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

// класс работника
public class Employee implements Serializable{

    // поля
    protected String surname;               // фамилия
    protected String name;                  // имя
    protected String patronymic;            // отчество
    protected LocalDate birthDate;          // дата рождения
    protected String gender;                // пол
    protected String telNumber;             // контактный номер телефона
    protected String post;                  // должность
    protected String department;            // наименование отдела
    protected String chief;                 // начальник
    protected LocalDate employmentDate;     // дата приема на работу
    protected Double salary;                // зарплата

    // геттеры

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getTelNumber() {
        return telNumber;
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

    public String getPost() {
        return post;
    }

    public String getDepartment() {
        return department;
    }

    public String getChief() {
        return chief;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public Double getSalary() {
        return salary;
    }

    // сеттеры

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    // конструктор

    public Employee(String surname, String name, String patronymic,
                    LocalDate birthDate, String gender, String telNumber,
                    String post, String department, String chief,
                    LocalDate employmentDate, Double salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.gender = gender;
        this.telNumber = telNumber;
        this.post = post;
        this.department = department;
        this.chief = chief;
        this.employmentDate = employmentDate;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "'" + surname + '\'' +
                "'" + name + '\'' +
                "'" + patronymic + '\'' +
                ", дата рождения '" + birthDate + '\'' +
                ", пол '" + gender + '\'' +
                ", номер телефона '" + telNumber + '\'' +
                ", должность '" + post + '\'' +
                ", отдел '" + department + '\'' +
                ", руководитель '" + chief + '\'' +
                ", дата приема на работу '" + employmentDate + '\'' +
                ", зарплата '" + salary + '\'';
    }
}
