package com.fujitsu.fs.javalab.bookshelf.service.interfaces;

import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Message;
import com.fujitsu.fs.javalab.bookshelf.models.Client;

import java.util.List;

/**
 * Created by Pc on 01.06.2016.
 */
public interface MessageService {

    List<Message> findMessageBySender(Client client);
    List<Message> findMessageByReceiver(Client client);
    void addNewMessage(Client sender, Client receiver, Book havingBook, Book wishingBook);
    void deleteById(Integer id);

}
