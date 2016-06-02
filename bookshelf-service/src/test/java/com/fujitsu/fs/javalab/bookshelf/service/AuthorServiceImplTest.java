package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.AuthorRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Author;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by aygulmardanova on 03.06.16.
 */
public class AuthorServiceImplTest {

    private static TestData testData;

    private static Author author;

    private static List<Author> authors;

    private static AuthorServiceImpl authorService;

    private static AuthorRepository authorRepository;

    @BeforeClass
    public static void beforeClassMethod() {
        testData = new TestData();
        author = testData.getAuthor();
        authors = testData.getAuthors();

        authorRepository = testData.getAuthorRepository();

        authorService = new AuthorServiceImpl();
        authorService.setAuthorRepository(authorRepository);
    }

    @Test
    public void getAllShouldReturnCorrectListOfAuthors() {
        Assert.assertEquals(authors, authorService.getAll());
    }

    @Test
    public void getAuthorByIdShouldReturnAuthorIfIdExists() {
        Assert.assertEquals(author, authorService.getAuthorById(author.getId()));
    }

    @Test
    public void getAuthorByIdShouldReturnNullIfIdDoesNotExist() {
        Assert.assertNull(authorService.getAuthorById(author.getId() + 100));
    }

    @Test
    public void getAuthorByFirstnameAndSurnameShouldReturnAuthorWithCorrectFirstnameAndSurname() {
        Assert.assertEquals(author.getFirstname(), authorService.getAuthorByFirstnameAndSurname(author.getFirstname(), author.getSurname()).getFirstname());
        Assert.assertEquals(author.getSurname(), authorService.getAuthorByFirstnameAndSurname(author.getFirstname(), author.getSurname()).getSurname());
    }

    @Test
    public void getAuthorByFirstnameAndSurnameShouldReturnCorrectAuthorForFirstameAndSurname() {
        Assert.assertEquals(author, authorService.getAuthorByFirstnameAndSurname(author.getFirstname(), author.getSurname()));
    }

    @Test
    public void getAuthorByFirstnameAndSurnameShouldReturnNullIfIncorrectSurname() {
        Assert.assertNull(authorService.getAuthorByFirstnameAndSurname(author.getFirstname(), ""));
    }

    @Test
    public void getAuthorByFirstnameAndSurnameShouldReturnNullIfIncorrectFirstname() {
        Assert.assertNull(authorService.getAuthorByFirstnameAndSurname("", author.getSurname()));
    }

    @Test
    public void getAuthorByFirstnameAndSurnameShouldReturnNullIfIncorrectData() {
        Assert.assertNull(authorService.getAuthorByFirstnameAndSurname("", ""));
    }

    @Test
    public void getAuthorByFirstnameAndSurnameAndMiddlenameShouldReturnCorrectAuthorIfRightData() {
        Assert.assertEquals(author, authorService.getAuthorByFirstnameAndSurnameAndMiddlename(author.getFirstname(), author.getSurname(), author.getMiddlename()));
    }

    @Test
    public void getAuthorByFirstnameAndSurnameAndMiddlenameShouldReturnNullIfIncorrectData() {
        Assert.assertNull(authorService.getAuthorByFirstnameAndSurnameAndMiddlename("", "", ""));
    }

    @Test
    public void getAuthorByFirstnameAndSurnameAndMiddlenameShouldReturnNullIfOneValueIsIncorrect() {
        Assert.assertNull(authorService.getAuthorByFirstnameAndSurnameAndMiddlename("", author.getSurname(), author.getMiddlename()));
    }

    @Test
    public void getAuthorByFirstnameAndSurnameAndMiddlenameShouldReturnNullIfTwoValuesAreIncorrect() {
        Assert.assertNull(authorService.getAuthorByFirstnameAndSurnameAndMiddlename("", "", author.getMiddlename()));
    }

    @Test
    public void addAuthorShouldReturnSavedAuthor() {
        Assert.assertEquals(author, authorService.addAuthor(author));
    }

}
