package com.devtiro.database.services;

import com.devtiro.database.domain.Entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<AuthorEntity> findOne(Long id);


    AuthorEntity save(AuthorEntity authorEntity);

    List<AuthorEntity> findAll();

    boolean isExists(Long id);
}
