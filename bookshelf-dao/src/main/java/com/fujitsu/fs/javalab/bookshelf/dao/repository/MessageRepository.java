package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * Returns all the {@code Messages} of the specified {@code Client}
     *
     * @param client sending {@code Client}
     * @return {@code List} of {@code Messages} or {@code null} if none was found
     */
    List<Message> findBySender(Client client);

    /**
     * Returns all the {@code Messages} of the specified Client
     *
     * @param client receiving {@code Client}
     * @return {@code List} of {@code Messages} or {@code null} if none was found
     */
    List<Message> findByReceiver(Client client);

    /**
     * Returns {@code Messages} with the specified id
     *
     * @param id {@code Message} unique identifier
     * @return {@code Messages} or {@code null} if couldn't find
     */
    Message findById(Integer id);

}
