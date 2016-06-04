package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.BookRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Book;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Test class for SearchServiceImpl class
 * Cover all possible situations
 */
public class SearchServiceImplTest {
    private static TestData testData;

    private static Author author;
    private static AuthorBookname authorBookname;
    private static Book book;
    private static List<Book> books;

    private static BookRepository bookRepository;
    private static SearchServiceImpl searchService;
    private static AuthorServiceImpl authorService;
    private static AuthorBooknameServiceImpl authorBooknameService;
    private static BookServiceImpl bookService;

    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();

        author = testData.getAuthor();
        authorBookname = testData.getAuthorBookname();
        book = testData.getBook();
        books = testData.getBooks();
        bookRepository = testData.getBookRepository();
        authorService = new AuthorServiceImpl();
        authorBooknameService = new AuthorBooknameServiceImpl();
        bookService = new BookServiceImpl();
        authorService.authorRepository = testData.getAuthorRepository();
        bookService.bookRepository = bookRepository;
        authorBooknameService.jpaRepositoryAuthorBookname = testData.getJpaRepositoryAuthorBookname();

        searchService = new SearchServiceImpl();
        searchService.authorService = authorService;
        searchService.authorBooknameService = authorBooknameService;
        searchService.bookService = bookService;
    }

    @Test
    public void getSearchResultShouldReturnNullIfSuchAuthorDoesNotExist() {
        Assert.assertNull(searchService.getSearchResult("", "", book.getAuthorBookname().getBookname()));
    }

    @Test
    public void getSearchResultShouldReturnNullIfCorrectOnlyOneOfAuthorNameOrSurname() {
        Assert.assertNull(searchService.getSearchResult(author.getFirstname(), "", book.getAuthorBookname().getBookname()));
    }

    @Test
    public void getSearchResultShouldReturnCorrectListOfBooksIfAuthorAndBooknameAreCorrect() {
        Assert.assertEquals(books, searchService.getSearchResult(author.getFirstname(), author.getSurname(), book.getAuthorBookname().getBookname()));
    }

    @Test
    public void getSearchResultShouldReturnNullIfAuthorExistButNoSuchBooks() {
        Assert.assertNull(searchService.getSearchResult(author.getFirstname(), author.getSurname(), ""));
    }

    @Test
    public void getSearchResultShouldReturnCorrectListOfBooksIfBooksExistForThisAuthorAndBookname() {
        Assert.assertEquals(books, searchService.getSearchResult(author.getFirstname(), author.getSurname(), book.getAuthorBookname().getBookname()));
    }

    @Test
    public void getSearchResultShouldCallFindAllByAuthorBooknameMethodInRepositoryForCorrectAuthorBookname() {
        searchService.getSearchResult(author.getFirstname(), author.getSurname(), book.getAuthorBookname().getBookname());
        verify(bookRepository, atLeastOnce()).findAllByAuthorBookname(authorBookname);
    }

}
