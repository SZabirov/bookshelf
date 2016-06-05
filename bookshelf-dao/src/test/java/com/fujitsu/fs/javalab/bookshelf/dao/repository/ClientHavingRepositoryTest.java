package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientHaving;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ClientHavingRepositoryTest {

    private static ClientHavingRepository clientHavingRepository;
    private static JpaRepositoryClient clientRepository;
    private static BookRepository bookRepository;

    @BeforeClass
    public static void prepareData() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("repository-config.xml");
        clientHavingRepository = ctx.getBean(ClientHavingRepository.class);
        clientRepository = ctx.getBean(JpaRepositoryClient.class);
        bookRepository = ctx.getBean(BookRepository.class);
    }

    @Test
    public void findAllMethodShouldReturnNotEmptyList() {
        Assert.assertNotNull(clientHavingRepository.findAll());
    }

    @Test
    public void findAllByClientMethodShouldReturnListOfHaving() {
        Client client = clientRepository.findOne(1);
        List<ClientHaving> havings = clientHavingRepository.findAllByClient(client);
        Assert.assertEquals(havings.size(), 2);
    }

    @Test
    public void findAllByBookMethodShouldReturnListOfHaving() {
        Book book = bookRepository.findOne(1);
        List<ClientHaving> havings = clientHavingRepository.findAllByBook(book);
        Assert.assertEquals(havings.size(), 2);
    }

    @Test
    public void findAllByClientAndBookMethodShouldReturnHaving() {
        Client client = clientRepository.findOne(1);
        Book book = bookRepository.findOne(3);
        Assert.assertEquals(clientHavingRepository.findByClientAndBook(client, book).getId(), 2);
    }

}
