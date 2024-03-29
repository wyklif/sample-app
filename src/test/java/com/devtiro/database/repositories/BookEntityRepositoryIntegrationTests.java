package com.devtiro.database.repositories;

import com.devtiro.database.TestDataUtil;
import com.devtiro.database.domain.Entities.AuthorEntity;
import com.devtiro.database.domain.Entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryIntegrationTests {
    private AuthorRepository authorDao;
    private BookRepository underTest;

    @Autowired
    public BookEntityRepositoryIntegrationTests(AuthorRepository authorDao, BookRepository underTest) {
        this.authorDao = authorDao;
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        authorDao.save(authorEntity);
        BookEntity bookEntity = TestDataUtil.createTestBookEntityA(authorEntity);
        bookEntity.setAuthorEntity(authorEntity);
        underTest.save(bookEntity);
        Optional<BookEntity> result =  underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntity);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        authorDao.save(authorEntity);
        BookEntity bookEntityA = TestDataUtil.createTestBookEntityA(authorEntity);
        bookEntityA.setAuthorEntity(authorEntity);
        underTest.save(bookEntityA);
        BookEntity bookEntityB = TestDataUtil.createTestBookB(authorEntity);
        bookEntityB.setAuthorEntity(authorEntity);
        underTest.save(bookEntityB);
        BookEntity bookEntityC = TestDataUtil.createTestBookC(authorEntity);
        bookEntityC.setAuthorEntity(authorEntity);
        underTest.save(bookEntityC);

        Iterable<BookEntity> result = underTest.findAll();
        assertThat(result).hasSize(3).containsExactly(bookEntityA, bookEntityB, bookEntityC);
    }

    @Test
    public void testThatBookCanBeUpdated(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        authorDao.save(authorEntity);
        BookEntity bookEntityA = TestDataUtil.createTestBookEntityA(authorEntity);
        bookEntityA.setAuthorEntity(authorEntity);
        underTest.save(bookEntityA);
        bookEntityA.setTitle("Updated");
        underTest.save(bookEntityA);

       Optional result =  underTest.findById(bookEntityA.getIsbn());
       assertThat(result).isPresent();
       assertThat(result.get()).isEqualTo(bookEntityA);
    }

    @Test
    public void testThatBookCanBeDeleted(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        authorDao.save(authorEntity);
        BookEntity bookEntityA = TestDataUtil.createTestBookEntityA(authorEntity);
        bookEntityA.setAuthorEntity(authorEntity);
        underTest.deleteById(bookEntityA.getIsbn());
        Optional<BookEntity> result = underTest.findById(bookEntityA.getIsbn());
        assertThat(result).isEmpty();

    }
}
