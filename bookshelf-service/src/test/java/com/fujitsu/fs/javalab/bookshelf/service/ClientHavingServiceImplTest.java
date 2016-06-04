package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.AuthorRepository;
import com.fujitsu.fs.javalab.bookshelf.dao.repository.BookRepository;
import com.fujitsu.fs.javalab.bookshelf.dao.repository.JpaRepositoryAuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.dao.repository.ClientHavingRepository;
import com.fujitsu.fs.javalab.bookshelf.models.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by aygulmardanova on 03.06.16.
 */
public class ClientHavingServiceImplTest {

    private static TestData testData;
    private static Client client;
    private static Book book;
    private static Author author;
    private static AuthorBookname authorBookname;
    private static ClientHaving clientHaving;
    private static List<ClientHaving> clientHavings;
    private static ClientHavingRepository clientHavingRepository;
    private static AuthorRepository authorRepository;
    private static JpaRepositoryAuthorBookname jpaRepositoryAuthorBookname;

    private static BookRepository bookRepository;
    private static ClientHavingServiceImpl clientHavingService;
    private static AuthorServiceImpl authorService;
    private static AuthorBooknameServiceImpl authorBooknameService;
    private static BookServiceImpl bookService;

    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();

        client = testData.getClient();
        book = testData.getBook();
        author = testData.getAuthor();
        authorBookname = testData.getAuthorBookname();
        clientHaving = testData.getClientHaving();
        clientHavings = testData.getClientHavings();

        clientHavingRepository = testData.getClientHavingRepository();
        authorRepository = testData.getAuthorRepository();
        bookRepository = testData.getBookRepository();
        jpaRepositoryAuthorBookname = testData.getJpaRepositoryAuthorBookname();

        clientHavingService = new ClientHavingServiceImpl();
        authorService = new AuthorServiceImpl();
        authorBooknameService = new AuthorBooknameServiceImpl();
        bookService = new BookServiceImpl();

        authorService.authorRepository = authorRepository;
        authorBooknameService.jpaRepositoryAuthorBookname = jpaRepositoryAuthorBookname;
        bookService.bookRepository = bookRepository;

        clientHavingService.clientHavingRepository = clientHavingRepository;
        clientHavingService.authorService = authorService;
        clientHavingService.authorBooknameService = authorBooknameService;
        clientHavingService.bookService = bookService;
    }

    @Test
    public void getAllByClientShouldReturnCorrectListForExistingClientIfHavingsExist() {
        Assert.assertEquals(clientHavings, clientHavingService.getAllByClient(client));
    }

    @Test
    public void getAllByClientShouldReturnNullNoHavingsForThisClient() {
        Assert.assertNull(clientHavingService.getAllByClient(new Client()));
    }

    @Test
    public void getAllClientForBookShouldReturnCorrectListOfClientIfHavingsExistForThisBook() {
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);
        Assert.assertEquals(clientList, clientHavingService.getAllClientForBook(book));
    }

    @Test
    public void getAllClientForBookShouldReturnNullIfNoHavingsForThisBook() {
        Assert.assertNull(clientHavingService.getAllClientForBook(new Book()));
    }

    @Test
    public void getAllBooksThatClientHasShouldReturnNonEmptyListIfClientHasBooks() {
        List<Book> books = new ArrayList<>();
        books.add(book);
        Assert.assertEquals(books, clientHavingService.getAllBooksThatClientHas(client));
    }

    @Test
    public void getAllBooksThatClientHasShouldReturnNullIfClientHasNoBooks() {
        Assert.assertNull(clientHavingService.getAllBooksThatClientHas(new Client()));
    }

    @Test
    public void deleteClientHavingShouldCallDeleteMethodInRepository() {
        clientHavingService.deleteClientHaving(client, book);
        verify(clientHavingRepository).delete(any(ClientHaving.class));
    }

    @Test
    public void createClientHavingShouldCallSaveMethodInRepository() {
        clientHavingService.createClientHaving(client, book);
        verify(clientHavingRepository, atLeastOnce()).save(any(ClientHaving.class));
    }

    @Test
    public void addClientHavingShouldCreateNewAuthorIfItDoesNotExist() {
        clientHavingService.addClientHaving(client, "name", author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), book.getAuthorBookname().getBookname());
        verify(authorRepository, atLeastOnce()).save(any(Author.class));
    }

    @Test
    public void addClientHavingShouldNotCreateNewAuthorIfItExists() {
        clientHavingService.addClientHaving(client, author.getFirstname(), author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), book.getAuthorBookname().getBookname());
        verify(authorRepository, never()).save(author);
    }

    @Test
    public void addClientHavingShouldCreateNewAuthorBooknameIfItDoesNotExist() {
        clientHavingService.addClientHaving(client, author.getFirstname(), author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), "");
        verify(jpaRepositoryAuthorBookname, atLeastOnce()).save(any(AuthorBookname.class));
    }

    @Test
    public void addClientHavingShouldNotCreateNewAuthorBooknameIfItExists() {
        clientHavingService.addClientHaving(client, author.getFirstname(), author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), book.getAuthorBookname().getBookname());
        verify(jpaRepositoryAuthorBookname, never()).save(authorBookname);
    }

    @Test
    public void addClientHavingShouldCallSaveMethodInBookRepository() {
        clientHavingService.addClientHaving(client, author.getFirstname(), author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), book.getAuthorBookname().getBookname());
        verify(bookRepository, atLeastOnce()).save(any(Book.class));
    }

    @Test
    public void addClientHavingShouldReturnClientHavingAfterTheCreating() {
        ClientHaving uh1 = clientHavingService.addClientHaving(client, author.getFirstname(), author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), book.getAuthorBookname().getBookname());
        Assert.assertEquals(clientHaving, uh1);
    }
}
