package com.devtiro.database.services.impl;

import com.devtiro.database.domain.Entities.AuthorEntity;
import com.devtiro.database.repositories.AuthorRepository;
import com.devtiro.database.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository  authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
