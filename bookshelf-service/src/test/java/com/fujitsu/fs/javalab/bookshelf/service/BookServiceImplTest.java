package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.BookRepository;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Book;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookServiceImplTest {

    private static TestData testData;
    private static Book book;
    private static List<Book> books;
    private static AuthorBookname authorBookname;

    private static BookRepository bookRepository;

    private static BookServiceImpl bookService;

    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();

        authorBookname = testData.getAuthorBookname();
        book = testData.getBook();
        books = testData.getBooks();
        bookRepository = testData.getBookRepository();
        bookService = new BookServiceImpl();
        bookService.bookRepository = bookRepository;
    }

    @Test
    public void getAllShouldReturnCorrectList() {
        Assert.assertEquals(books, bookService.getAll());
    }

    @Test
    public void getBookByIdShouldReturnCorrectBookIfIdExists() {
        Assert.assertEquals(book, bookService.getById(book.getId()));
    }

    @Test
    public void getBookByIdShouldReturnNullBookIfIdDoesNotExists() {
        Assert.assertNull(bookService.getById(book.getId() + 100));
    }

    @Test
    public void ifBookIsVerifiedShouldReturnTrueIfVerifiedBook() {
        Assert.assertTrue(bookService.ifBookIsVerified(book.getId()));
    }

    @Test
    public void ifBookIsVerifiedShouldReturnFalseIfNotVerifiedBook() {
        Book book2 = new Book();
        book2.setVerified(false);
        when(bookRepository.findById(book2.getId())).thenReturn(book2);
        Assert.assertFalse(bookService.ifBookIsVerified(book2.getId()));
    }

    @Test
    public void getBooksByAuthorBooknameShouldReturnCorrectBookIfCorrectAuthorBookname() {
        Assert.assertEquals(books, bookService.getBooksByAuthorBookname(authorBookname));
    }

    @Test
    public void getBooksByAuthorBooknameShouldReturnNullIfNoBooksForAuthorBookname() {
        Assert.assertNull(bookService.getBooksByAuthorBookname(new AuthorBookname()));
    }

    @Test
    public void addBookShouldReturnSavedBook() {
        Assert.assertEquals(book, bookService.addBook(book));
    }

    @Test
    public void addBookMethodShouldCallSaveMethodInRepository() {
        bookService.addBook(book);
        verify(bookRepository, atLeastOnce()).save(book);
    }
}
