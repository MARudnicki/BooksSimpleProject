package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {

    private BookDao bookDao;

    public BooksService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    List<BookDto> findAll() {
        return bookDao.findAll().stream()
                .map(book -> new BookDto(book.getValue(), book.getAge()))
                .collect(Collectors.toList());
    }

    BookDto findByValue(String value) {
        return bookDao.findByValue(value)
                .map(book -> new BookDto(book.getValue(), book.getAge()))
                .orElseThrow(BookException::new);
    }

    void create(BookDto bookDto){

        Book book = Book.newBook()
                .age(bookDto.getAge())
                .value(bookDto.getValue())
                .build();

        bookDao.save(book);
    }
}
