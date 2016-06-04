package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.MessageRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Message;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public List<Message> findMessageBySender(Client client) {
        return messageRepository.findBySender(client);
    }

    @Override
    public List<Message> findMessageByReceiver(Client client) {
        return messageRepository.findByReceiver(client);
    }

    @Override
    public void addNewMessage(Client sender, Client receiver, Book havingBook, Book wishingBook) {
        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setHavingBook(havingBook);
        message.setWishBook(wishingBook);
        messageRepository.save(message);
    }

    @Override
    public void deleteById(Integer id) {
        Message message = messageRepository.findById(id);
        messageRepository.delete(message);
    }

}
