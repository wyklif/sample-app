package com.devtiro.database.controllers;

import com.devtiro.database.domain.Entities.BookEntity;
import com.devtiro.database.domain.dto.BookDto;
import com.devtiro.database.mappers.Mapper;
import com.devtiro.database.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private BookService bookService;
    private Mapper<BookEntity, BookDto> bookMapper;

    public BookController(BookService bookService, Mapper<BookEntity, BookDto> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable("isbn") String isbn, @RequestBody BookDto book){
        BookEntity bookEntity = bookMapper.mapFrom(book);
        BookEntity savedBookEntity =  bookService.createBook(isbn,bookEntity);
        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity), HttpStatus.CREATED);
    }
}
