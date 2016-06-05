package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.*;
import com.fujitsu.fs.javalab.bookshelf.models.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by aygulmardanova on 05.06.16.
 */
public class ClientWishServiceImplTest {

    private static TestData testData;
    private static Client client;
    private static Book book;
    private static Author author;
    private static AuthorBookname authorBookname;
    private static ClientWish clientWish;
    private static ClientWish new_wish;
    private static List<AuthorBookname> authorBooknames;
    private static List<ClientWish> clientWishes;
    private static ClientWishRepository clientWishRepository;
    private static AuthorRepository authorRepository;
    private static JpaRepositoryAuthorBookname jpaRepositoryAuthorBookname;

    private static BookRepository bookRepository;
    private static ClientWishServiceImpl clientWishService;
    private static AuthorServiceImpl authorService;
    private static AuthorBooknameServiceImpl authorBooknameService;

    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();

        client = testData.getClient();
        book = testData.getBook();
        author = testData.getAuthor();
        authorBookname = testData.getAuthorBookname();
        clientWish = testData.getClientWish();
        authorBooknames = testData.getAuthorBooknames();
        clientWishes = testData.getClientWishes();
        client.setClientWishs(clientWishes);
        new_wish = new ClientWish();
        new_wish.setId(100);
        new_wish.setClient(new Client());
        new_wish.setAuthorBookname(new AuthorBookname());

        clientWishRepository = testData.getClientWishRepository();
        authorRepository = testData.getAuthorRepository();
        bookRepository = testData.getBookRepository();
        jpaRepositoryAuthorBookname = testData.getJpaRepositoryAuthorBookname();

        clientWishService = new ClientWishServiceImpl();
        authorService = new AuthorServiceImpl();
        authorBooknameService = new AuthorBooknameServiceImpl();

        authorService.authorRepository = authorRepository;
        authorBooknameService.jpaRepositoryAuthorBookname = jpaRepositoryAuthorBookname;

        clientWishService.clientWishRepository = clientWishRepository;
        clientWishService.authorService = authorService;
        clientWishService.authorBooknameService = authorBooknameService;
    }

    @Test
    public void getAllClientWishesForClientShouldReturnCorrectListIfWishesExistForThisClient() {
        Assert.assertEquals(clientWishes, clientWishService.getAllClientWishesForClient(client));
    }

    @Test
    public void getAllClientWishesForClientShouldReturnNullIfSuchClientDoesNotExistOrNoWIshesForThisClient() {
        Assert.assertNull(clientWishService.getAllClientWishesForClient(new Client()));
    }

    @Test
    public void getAllBooksThatClientWishesShouldReturnCorrectListOfBooksIfWishesExist() {
        Assert.assertEquals(authorBooknames, clientWishService.getAllBooksThatClientWishes(client));
    }

    @Test
    public void getAllBooksThatClientWishesShouldReturnNullIfNoWishesForClient() {
        Assert.assertNull(clientWishService.getAllBooksThatClientWishes(new Client()));
    }

    @Test
    public void deleteByIdShouldDoNothingIfIdDoesNotExist() {
        clientWishService.deleteById(new_wish.getId());
        verify(clientWishRepository, never()).delete(new_wish);
    }

    @Test
    public void deleteByIdShouldCallDeleteMethodInRepositoryIfClientWishExists() {
        clientWishService.deleteById(clientWish.getId());
        verify(clientWishRepository, atLeastOnce()).delete(clientWish);
    }

    @Test
    public void deleteClientWishShouldCallDeleteMethodInRepositoryIfForClientAndAuthorBooknameClientWishExists() {
        clientWishService.deleteClientWish(client, authorBookname);
        verify(clientWishRepository, atLeastOnce()).delete(clientWish);
    }

    @Test
    public void deleteClientWishShouldDoNothingIfForClientAndAuthorBooknameClientWishDoesNotExist() {
        clientWishService.deleteClientWish(new_wish.getClient(), new_wish.getAuthorBookname());
        verify(clientWishRepository, never()).delete(new_wish);
    }

    @Test
    public void addClientWishShouldCallSaveMethodInRepositoryAndReturnClientWishWithCorrectClientAndAuthorBookname() {
        ClientWish clientWish1 = clientWishService.addClientWish(client, authorBookname);
        verify(clientWishRepository).save(clientWish);
        Assert.assertEquals(client, clientWish1.getClient());
        Assert.assertEquals(authorBookname, clientWish1.getAuthorBookname());
    }

    @Test
    public void addWishingShouldCallSaveMethodInAuthorRepositoryIfAuthorDoesNotExist() {
        clientWishService.addWishing("", "", "", authorBookname.getBookname(), client);
        verify(authorRepository).save(any(Author.class));
    }

    @Test
    public void addWishingShouldCallSaveMethodInAuthorBooknameRepositoryIfAuthorBooknameDoesNotExist() {
        clientWishService.addWishing(author.getFirstname(), author.getSurname(), author.getMiddlename(), "", client);
        verify(jpaRepositoryAuthorBookname, atLeastOnce()).save(any(AuthorBookname.class));
        verify(jpaRepositoryAuthorBookname, atMost(2)).save(any(AuthorBookname.class));
    }

    @Test
    public void addWishingShouldReturnClientWishWithCorrectParameters() {
        ClientWish clientWish1 = clientWishService.addWishing(author.getFirstname(), author.getSurname(), author.getMiddlename(), authorBookname.getBookname(), client);
        Assert.assertEquals(author, clientWish1.getAuthorBookname().getAuthor());
        Assert.assertEquals(authorBookname, clientWish1.getAuthorBookname());
        Assert.assertEquals(client, clientWish1.getClient());
    }

    @Test
    public void addWishingShouldNotCallSaveMethodIfClientWishExists() {
        ClientWish clientWish1 = new ClientWish();
        clientWish1.setClient(client);
        clientWish1.setAuthorBookname(authorBookname);
        verify(clientWishRepository, never()).save(clientWish1);
    }
}