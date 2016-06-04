package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.models.Book;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by aygulmardanova on 03.06.16.
 */
public class SearchServiceImplTest {
    private static TestData testData;

    private static Book book;
    private static List<Book> books;

    private static SearchServiceImpl searchService;
    private static AuthorServiceImpl authorService;
    private static AuthorBooknameServiceImpl authorBooknameService;
    private static BookServiceImpl bookService;

    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();

        book = testData.getBook();
        books = testData.getBooks();
        authorService = new AuthorServiceImpl();
        authorBooknameService = new AuthorBooknameServiceImpl();
        bookService = new BookServiceImpl();
        authorService.authorRepository = testData.getAuthorRepository();
        authorBooknameService.jpaRepositoryAuthorBookname = testData.getJpaRepositoryAuthorBookname();
        bookService.bookRepository = testData.getBookRepository();

        searchService = new SearchServiceImpl();
        searchService.authorService = authorService;
        searchService.authorBooknameService = authorBooknameService;
        searchService.bookService = bookService;
    }

    // TODO: 04.06.2016 fix it!!!
    @Ignore
    @Test
    public void getSearchResultShouldReturnCorrectListOfBooks() {
        Assert.assertEquals(books, searchService.getSearchResult(book.getAuthorBookname().getAuthor().getFirstname(),
                book.getAuthorBookname().getAuthor().getSurname(),
                book.getAuthorBookname().getBookname()));
    }
}
