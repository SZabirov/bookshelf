package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.AuthorRepository;
import com.fujitsu.fs.javalab.bookshelf.dao.repository.BookRepository;
import com.fujitsu.fs.javalab.bookshelf.dao.repository.JpaRepositoryAuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.dao.repository.UsersHavingRepository;
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
public class UsersHavingServiceImplTest {

    private static TestData testData;
    private static Users users;
    private static Book book;
    private static Author author;
    private static AuthorBookname authorBookname;
    private static UsersHaving usersHaving;
    private static List<UsersHaving> usersHavings;
    private static UsersHavingRepository usersHavingRepository;
    private static AuthorRepository authorRepository;
    private static JpaRepositoryAuthorBookname jpaRepositoryAuthorBookname;

    private static BookRepository bookRepository;
    private static UsersHavingServiceImpl usersHavingService;
    private static AuthorServiceImpl authorService;
    private static AuthorBooknameServiceImpl authorBooknameService;
    private static BookServiceImpl bookService;


    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();

        users = testData.getUsers();
        book = testData.getBook();
        author = testData.getAuthor();
        authorBookname = testData.getAuthorBookname();
        usersHaving = testData.getUsersHaving();
        usersHavings = testData.getUsersHavings();

        usersHavingRepository = testData.getUsersHavingRepository();
        authorRepository = testData.getAuthorRepository();
        bookRepository = testData.getBookRepository();
        jpaRepositoryAuthorBookname = testData.getJpaRepositoryAuthorBookname();

        usersHavingService = new UsersHavingServiceImpl();
        authorService = new AuthorServiceImpl();
        authorBooknameService = new AuthorBooknameServiceImpl();
        bookService = new BookServiceImpl();

        authorService.authorRepository = authorRepository;
        authorBooknameService.jpaRepositoryAuthorBookname = jpaRepositoryAuthorBookname;
        bookService.bookRepository = bookRepository;

        usersHavingService.usersHavingRepository = usersHavingRepository;
        usersHavingService.authorService = authorService;
        usersHavingService.authorBooknameService = authorBooknameService;
        usersHavingService.bookService = bookService;
    }

    @Test
    public void getAllByUserShouldReturnCorrectListForExistingUserIfHavingsExist() {
        Assert.assertEquals(usersHavings, usersHavingService.getAllByUser(users));
    }

    @Test
    public void getAllByUserShouldReturnNullNoHavingsForThisUser() {
        Assert.assertNull(usersHavingService.getAllByUser(new Users()));
    }

    @Test
    public void getAllUsersForBookShouldReturnCorrectListOfUsersIfHavingsExistForThisBook() {
        List<Users> usersList = new ArrayList<>();
        usersList.add(users);
        Assert.assertEquals(usersList, usersHavingService.getAllUsersForBook(book));
    }

    @Test
    public void getAllUsersForBookShouldReturnNullIfNoHavingsForThisBook() {
        Assert.assertNull(usersHavingService.getAllUsersForBook(new Book()));
    }

    @Test
    public void getAllBooksThatUserHasShouldReturnNonEmptyListIfUserHasBooks() {
        List<Book> books = new ArrayList<>();
        books.add(book);
        Assert.assertEquals(books, usersHavingService.getAllBooksThatUserHas(users));
    }

    @Test
    public void getAllBooksThatUserHasShouldReturnNullIfUserHasNoBooks() {
        Assert.assertNull(usersHavingService.getAllBooksThatUserHas(new Users()));
    }

    @Test
    public void deleteUsersHavingShouldCallDeleteMethodInRepository() {
        usersHavingService.deleteUsersHaving(users, book);
        verify(usersHavingRepository).delete(any(UsersHaving.class));
    }

    @Test
    public void createUsersHavingShouldCallSaveMethodInRepository() {
        usersHavingService.createUsersHaving(users, book);
        verify(usersHavingRepository, atLeastOnce()).save(any(UsersHaving.class));
    }

    @Test
    public void addUsersHavingShouldCreateNewAuthorIfItDoesNotExist() {
        usersHavingService.addUsersHaving(users, "name", author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), book.getAuthorBookname().getBookname());
        verify(authorRepository, atLeastOnce()).save(any(Author.class));
    }

    @Test
    public void addUsersHavingShouldNotCreateNewAuthorIfItExists() {
        usersHavingService.addUsersHaving(users, author.getFirstname(), author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), book.getAuthorBookname().getBookname());
        verify(authorRepository, never()).save(author);
    }

    @Test
    public void addUsersHavingShouldCreateNewAuthorBooknameIfItDoesNotExist() {
        usersHavingService.addUsersHaving(users, author.getFirstname(), author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), "");
        verify(jpaRepositoryAuthorBookname, atLeastOnce()).save(any(AuthorBookname.class));
    }

    @Test
    public void addUsersHavingShouldNotCreateNewAuthorBooknameIfItExists() {
        usersHavingService.addUsersHaving(users, author.getFirstname(), author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), book.getAuthorBookname().getBookname());
        verify(jpaRepositoryAuthorBookname, never()).save(authorBookname);
    }

    @Test
    public void addUsersHavingShouldCallSaveMethodInBookRepository() {
        usersHavingService.addUsersHaving(users, author.getFirstname(), author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), book.getAuthorBookname().getBookname());
        verify(bookRepository, atLeastOnce()).save(any(Book.class));
    }

    @Test
    public void addUsersHavingShouldReturnUsersHavingAfterTheCreating() {
        UsersHaving uh1 = usersHavingService.addUsersHaving(users, author.getFirstname(), author.getSurname(),
                author.getMiddlename(), book.getPubhouse(), book.getPubYear(),
                book.getDescription(), book.getAuthorBookname().getBookname());
        Assert.assertEquals(usersHaving, uh1);
    }
}
