package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * Returns all the messages of the specified Client
     *
     * @param client
     * @return List of Messages or null if none was found
     */
    List<Message> findBySender(Client client);

    /**
     * Returns all the messages of the specified Client
     *
     * @param client
     * @return list of Messages or null if none was found
     */
    List<Message> findByReceiver(Client client);

    /**
     * Returns Message with the specified id
     *
     * @param id unique identifier
     * @return Message or null if couldn't find
     */
    Message findById(Integer id);

}
