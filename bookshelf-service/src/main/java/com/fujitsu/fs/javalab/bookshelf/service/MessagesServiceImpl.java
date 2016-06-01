package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.MessagesRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Messages;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    MessagesRepository messagesRepository;


    @Override
    public List<Messages> findMessageBySender(Users user) {
        return messagesRepository.findBySender(user);
    }

    @Override
    public List<Messages> findMessageByReceiver(Users user) {
        return messagesRepository.findByReceiver(user);
    }
}
