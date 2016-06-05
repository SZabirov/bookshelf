package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientRepositoryTest {

    private static JpaRepositoryClient clientRepository;

    @BeforeClass
    public static void prepareData() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("repository-config.xml");
        clientRepository = ctx.getBean(JpaRepositoryClient.class);
    }

    @Test
    public void findByIdMethodShouldReturnClient() {
        Assert.assertEquals(clientRepository.findById(1).getId(), 1);
    }

    @Test
    public void findByNicknameMethodShouldReturnClient() {
        Assert.assertEquals(clientRepository.findByNickname("Ivan").getId(), 1);
    }

    @Test
    public void findByEmailMethodShouldReturnClient() {
        Assert.assertEquals(clientRepository.findByEmail("ivan@mail.ru").getId(), 1);
    }

}
