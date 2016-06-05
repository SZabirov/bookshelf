package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.Message;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MessageRepositoryTest {

    private static MessageRepository messageRepository;
    private static JpaRepositoryClient clientRepository;

    @BeforeClass
    public static void prepareData() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("repository-config.xml");
        messageRepository = ctx.getBean(MessageRepository.class);
        clientRepository = ctx.getBean(JpaRepositoryClient.class);
    }

    @Test
    public void findByIdMethodShouldReturnClient() {
        Assert.assertEquals(messageRepository.findById(2).getId(), 2);
    }

    @Test
    public void findBySenderMethodShouldReturnListOfMessages() {
        Client client = clientRepository.findOne(1);
        List<Message> messages = messageRepository.findBySender(client);
        Assert.assertEquals(messages.size(), 1);
    }

    @Test
    public void findByReceiverMethodShouldReturnListOfMessages() {
        Client client = clientRepository.findOne(2);
        List<Message> messages = messageRepository.findByReceiver(client);
        Assert.assertEquals(messages.size(), 1);
    }

}
