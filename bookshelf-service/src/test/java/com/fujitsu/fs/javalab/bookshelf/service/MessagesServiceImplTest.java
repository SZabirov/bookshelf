package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.MessagesRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Messages;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by aygulmardanova on 03.06.16.
 */
public class MessagesServiceImplTest {

    private static TestData testData;

    private static Users users;
    private static Users users2;
    private static Messages messages;
    private static List<Messages> messagesList;
    private static MessagesRepository messagesRepository;
    private static MessagesServiceImpl messagesService;

    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();

        users = testData.getUsers();
        users2 = testData.getUsers2();
        messages = testData.getMessages();
        messagesList = testData.getMessagesList();

        messagesRepository = testData.getMessagesRepository();
        messagesService = new MessagesServiceImpl();
        messagesService.messagesRepository = messagesRepository;
    }

    @Test
    public void findMessageByReceiverShouldReturnCorrectListOfMessagesIfReceiverMessagesExistForThisUser() {
        Assert.assertEquals(messagesList, messagesService.findMessageByReceiver(users));
    }

    @Test
    public void findMessageByReceiverShouldReturnNullIfNoReceivedMessagesForThisUser() {
        Assert.assertNull(messagesService.findMessageByReceiver(users2));
    }

    @Test
    public void findMessageBySenderShouldReturnCorrectListOfMessagesIfSentMessagesExistForThisUser() {
        Assert.assertEquals(messagesList, messagesService.findMessageBySender(users2));
    }

    @Test
    public void findMessageBySenderShouldReturnNullIfNoSentMessagesForThisUser() {
        Assert.assertNull(messagesService.findMessageBySender(users));
    }

    @Test
    public void addNewMessageShouldCallSaveMethodInRepository() {
        messagesService.addNewMessage(messages.getSender(), messages.getReceiver(), messages.getHavingBook(), messages.getWishBook());
        verify(messagesRepository).save(any(Messages.class));
    }

    @Test
    public void deleteByIdShouldCallDeleteMethodInRepository() {
        messagesService.deleteById(messages.getId());
        verify(messagesRepository).delete(messages);
    }
}
