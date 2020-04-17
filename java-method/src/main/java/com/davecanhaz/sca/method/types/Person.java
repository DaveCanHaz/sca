package com.davecanhaz.sca.method.types;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class Person {
    public String name;
    public int age;

    @JsonTypeInfo(use = Id.CLASS)
    public Object phone;


    public Person() {
    }

    public Person(String name, int age, Object phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object getPhone() {
        return this.phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public Person age(int age) {
        this.age = age;
        return this;
    }

    public Person phone(Object phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", phone='" + getPhone() + "'" +
            "}";
    }

}