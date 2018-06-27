package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookDao extends CrudRepository<Book, Long> {

    List<Book> findAll();

    Optional<Book> findByValue(String value);
}
