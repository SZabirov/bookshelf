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
     * Returns all the {@code ClientHavings}
     *
     * @return {@code List} of {@code ClientHavings} or {@code null} if found nothing
     */
    List<ClientHaving> findAll();

    /**
     * Returns all the {@code ClientHavings}
     * of specified client {@code Client}
     *
     * @param client {@code Client} to search for {@code ClientHavings} of
     * @return {@code List} of {@code ClientHavings} or {@code null} if found nothing
     */
    List<ClientHaving> findAllByClient(Client client);

    /**
     * Returns all the {@code ClientHavings}
     * for specified {@code Book}
     *
     * @param book {@code Book} to search {@code ClientHavings} for
     * @return {@code List} of {@code ClientHavings} or {@code null} if found nothing
     */
    List<ClientHaving> findAllByBook(Book book);

    /**
     * Returns {@code ClientHaving} with specified client and book
     *
     * @param client {@code Client} to search for {@code ClientHavings} of
     * @param book   {@code Book} to search for {@code ClientHavings} with
     * @return {@code ClientHaving} or {@code null} if found nothing
     */
    ClientHaving findByClientAndBook(Client client, Book book);
}
