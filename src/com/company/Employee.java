package com.company;

public class Employee {
    private String name;
    private String surname;
    private int birthYear;
    private int beginWorkYear;
    EnumEmployee enumEmployee;

    public Employee() {
    }

    public void setEnumEmployee(EnumEmployee enumEmployee) {
        this.enumEmployee = enumEmployee;
    }

    public EnumEmployee getEnumEmployee() {
        return enumEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBeginWorkYear() {
        return beginWorkYear;
    }

    public void setBeginWorkYear(int beginWorkYear) {
        this.beginWorkYear = beginWorkYear;
    }
}