package com.devtiro.database.services;

import com.devtiro.database.domain.Entities.BookEntity;

public interface BookService {

    BookEntity createBook(String isbn, BookEntity bookEntity);
}
