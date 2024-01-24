package com.devtiro.database;

import com.devtiro.database.domain.Entities.AuthorEntity;
import com.devtiro.database.domain.Entities.BookEntity;
import com.devtiro.database.domain.dto.AuthorDto;
import com.devtiro.database.domain.dto.BookDto;

public final class TestDataUtil {

    private TestDataUtil(){

    }


    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static AuthorDto createTestAuthorDtoA() {
        return AuthorDto.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }
    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Thomas cronin")
                .age(44)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Jesse A Casey")
                .age(24)
                .build();
    }

    public static BookEntity createTestBookEntityA(AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-8")
                .title("The Shadow in the attic")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookDto createTestBookDtoA(final AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("978-1-2345-6789-8")
                .title("The Shadow in the attic")
                .author(authorDto)
                .build();
    }
    public static BookEntity createTestBookB(AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-9")
                .title("The Shadow in the attic 2")
                .authorEntity(authorEntity)
                .build();
    }
    public static BookEntity createTestBookC(AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the attic 3")
                .authorEntity(authorEntity)
                .build();
    }
}
