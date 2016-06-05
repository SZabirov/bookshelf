package com.fujitsu.fs.javalab.bookshelf.service.interfaces;

import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.Message;

import java.util.List;

/**
 * Created by Pc on 01.06.2016.
 */
public interface MessageService {

    /**
     * Returns all sent messages of the Client.
     *
     * @param client
     * @return list of Messages or null if ther is none
     */
    List<Message> findMessageBySender(Client client);

    /**
     * Returns all recieved messages of the Client.
     *
     * @param client
     * @return list of Messages or null if there is none
     */
    List<Message> findMessageByReceiver(Client client);

    /**
     * Adds new Message
     *
     * @param sender
     * @param receiver
     * @param havingBook
     * @param wishingBook
     */
    void addNewMessage(Client sender, Client receiver, Book havingBook, Book wishingBook);

    /**
     * Deletes Message by ID
     *
     * @param id
     */
    void deleteById(Integer id);

}
