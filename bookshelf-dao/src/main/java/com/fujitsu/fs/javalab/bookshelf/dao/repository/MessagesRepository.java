package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Messages;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer> {

    List<Messages> findBySender(Users user);

    List<Messages> findByReceiver(Users user);

    Messages findById(Integer id);

}
