package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
public class BooksController {

    private BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    List<BookDto> getAll() {
        System.out.println("Get all books called");

        return booksService.findAll();
    }

    @GetMapping(value = "{value}")
    BookDto findById(@PathVariable String value) {
        System.out.println("Find by value " + value);

        return booksService.findByValue(value);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    void create(@RequestBody BookDto book) {
        System.out.println("Create book " + book);

        booksService.create(book);
    }

}
