package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Client;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TokenRepositoryTest {

    private static TokenRepository tokenRepository;
    private static JpaRepositoryClient clientRepository;

    @BeforeClass
    public static void prepareData() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("repository-config.xml");
        tokenRepository = ctx.getBean(TokenRepository.class);
        clientRepository = ctx.getBean(JpaRepositoryClient.class);
    }

    @Test
    public void findAllMethodShouldReturnNotEmptyList() {
        Assert.assertNotNull(tokenRepository.findAll());
    }

    @Test
    public void findByClientMethodShouldReturnToken() {
        Client client = clientRepository.findOne(1);
        Assert.assertEquals(tokenRepository.findAllByClient(client).get(0).getId(), 1);
    }



}
