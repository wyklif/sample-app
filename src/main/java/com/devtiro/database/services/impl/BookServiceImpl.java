package com.devtiro.database.services.impl;

import com.devtiro.database.domain.Entities.BookEntity;
import com.devtiro.database.repositories.BookRepository;
import com.devtiro.database.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return bookRepository.save(bookEntity);
    }
}
