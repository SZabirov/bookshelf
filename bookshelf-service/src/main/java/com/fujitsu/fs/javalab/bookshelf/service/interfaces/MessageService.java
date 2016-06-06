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
     * Returns all sent {@code Messages} of the {@code Client}.
     *
     * @param client - {@code Client} to show {@code Messages} of
     * @return {@code List} of {@code Messages} or {@code null} if there is none
     */
    List<Message> findMessageBySender(Client client);

    /**
     * Returns all recieved messages of the Client.
     *
     * @param client - {@code Client} to show {@code Messages} of
     * @return {@code List} of {@code Messages} or {@code null} if there is none
     */
    List<Message> findMessageByReceiver(Client client);

    /**
     * Adds new {@code Message}
     *
     * @param sender      {@code Client} to show sent {@code Messages} of
     * @param receiver    {@code Client} to show received {@code Messages} of
     * @param havingBook  {@code Book} in property
     * @param wishingBook wanted {@code Book}
     */
    void addNewMessage(Client sender, Client receiver, Book havingBook, Book wishingBook);

    /**
     * Deletes {@code Message} by ID
     *
     * @param id ID of the {@code Messages} to delete
     */
    void deleteById(Integer id);

}
