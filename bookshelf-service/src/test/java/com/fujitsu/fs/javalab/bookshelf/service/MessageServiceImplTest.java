package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.MessageRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Message;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by aygulmardanova on 03.06.16.
 */
public class MessageServiceImplTest {

    private static TestData testData;

    private static Client client;
    private static Client client2;
    private static Message message;
    private static List<Message> messageList;
    private static MessageRepository messageRepository;
    private static MessageServiceImpl messageService;

    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();

        client = testData.getClient();
        client2 = testData.getClient2();
        message = testData.getMessage();
        messageList = testData.getMessageList();

        messageRepository = testData.getMessageRepository();
        messageService = new MessageServiceImpl();
        messageService.messageRepository = messageRepository;
    }

    @Test
    public void findMessageByReceiverShouldReturnCorrectListOfMessageIfReceiverMessageExistForThisClient() {
        Assert.assertEquals(messageList, messageService.findMessageByReceiver(client));
    }

    @Test
    public void findMessageByReceiverShouldReturnNullIfNoReceivedMessageForThisClient() {
        Assert.assertNull(messageService.findMessageByReceiver(client2));
    }

    @Test
    public void findMessageBySenderShouldReturnCorrectListOfMessageIfSentMessageExistForThisClient() {
        Assert.assertEquals(messageList, messageService.findMessageBySender(client2));
    }

    @Test
    public void findMessageBySenderShouldReturnNullIfNoSentMessageForThisClient() {
        Assert.assertNull(messageService.findMessageBySender(client));
    }

    @Test
    public void addNewMessageShouldCallSaveMethodInRepository() {
        messageService.addNewMessage(message.getSender(), message.getReceiver(), message.getHavingBook(), message.getWishBook());
        verify(messageRepository).save(any(Message.class));
    }

    @Test
    public void deleteByIdShouldCallDeleteMethodInRepository() {
        messageService.deleteById(message.getId());
        verify(messageRepository).delete(message);
    }
}
