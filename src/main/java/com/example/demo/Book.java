package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

    @GeneratedValue
    @Id
    private Long id;

    private String value;

    private Integer age;

    public Book() {
    }

    private Book(Builder builder) {
        this.id = builder.id;
        this.value = builder.value;
        this.age = builder.age;
    }

    public static Builder newBook() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (value != null ? !value.equals(book.value) : book.value != null) return false;
        return age != null ? age.equals(book.age) : book.age == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", age=" + age +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String value;
        private Integer age;

        private Builder() {
        }

        public Book build() {
            return new Book(this);
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }
    }
}
