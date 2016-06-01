package com.fujitsu.fs.javalab.bookshelf.service.interfaces;

import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Messages;
import com.fujitsu.fs.javalab.bookshelf.models.Users;

import java.util.List;

/**
 * Created by Pc on 01.06.2016.
 */
public interface MessagesService {

    List<Messages> findMessageBySender(Users user);
    List<Messages> findMessageByReceiver(Users user);
    void addNewMessage(Users sender, Users receiver, Book havingBook, Book wishingBook);

}
