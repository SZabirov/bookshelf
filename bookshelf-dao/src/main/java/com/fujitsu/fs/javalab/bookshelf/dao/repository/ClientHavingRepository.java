package com.fujitsu.fs.javalab.bookshelf.dao.repository;


import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientHaving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface ClientHavingRepository extends JpaRepository<ClientHaving, Integer> {

    List<ClientHaving> findAll();

    List<ClientHaving> findAllByClient(Client client);

    List<ClientHaving> findAllByBook(Book book);

    ClientHaving findByClientAndBook(Client client, Book book);
}
