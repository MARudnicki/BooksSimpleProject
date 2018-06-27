package com.example.demo;

public class BookDto {

    private String value;

    private Integer age;

    public BookDto() {
    }

    public BookDto(String value, Integer age) {
        this.value = value;
        this.age = age;
    }

    public String getValue() {
        return value;
    }

    public Integer getAge() {
        return age;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
