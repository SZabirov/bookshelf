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

    /**
     * Returns all the ClientHavings
     *
     * @return ClientHaving or null if found nothing
     */
    List<ClientHaving> findAll();

    /**
     * Returns all the ClientHavings
     * of specified client
     *
     * @param client
     * @return list of ClientHavings or null if found nothing
     */
    List<ClientHaving> findAllByClient(Client client);

    /**
     * Returns all the ClientHavings
     * for specified book
     *
     * @param book
     * @return list of ClientHavings or null if found nothing
     */
    List<ClientHaving> findAllByBook(Book book);

    /**
     * Returns ClientHaving with specified client and book
     *
     * @param client
     * @param book
     * @return ClientHaving or null if found nothing
     */
    ClientHaving findByClientAndBook(Client client, Book book);
}
