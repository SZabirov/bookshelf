package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ClientWishRepositoryTest {

    private static ClientWishRepository clientWishRepository;
    private static JpaRepositoryClient clientRepository;
    private static JpaRepositoryAuthorBookname authorBooknameRepository;

    @BeforeClass
    public static void prepareData() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("repository-config.xml");
        clientWishRepository = ctx.getBean(ClientWishRepository.class);
        clientRepository = ctx.getBean(JpaRepositoryClient.class);
        authorBooknameRepository = ctx.getBean(JpaRepositoryAuthorBookname.class);
    }

    @Test
    public void findAllMethodShouldReturnNotEmptyList() {
        Assert.assertNotNull(clientWishRepository.findAll());
    }

    @Test
    public void findByIdMethodShouldReturnClientWish() {
        Assert.assertEquals(clientWishRepository.findById(2).getId(), 2);
    }

    @Test
    public void findByClientAndAuthorBooknameMethodShouldReturnClientWish() {
        Client client = clientRepository.findOne(1);
        AuthorBookname authorBookname = authorBooknameRepository.findOne(1);
        Assert.assertEquals(clientWishRepository.findByClientAndAuthorBookname(client, authorBookname).getId(), 1);
    }

    @Test
    public void findAllByClientMethodShouldReturnListOfHaving() {
        Client client = clientRepository.findOne(1);
        List<ClientWish> wishes = clientWishRepository.findAllByClient(client);
        Assert.assertEquals(wishes.size(), 3);
    }

}
