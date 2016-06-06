package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientHaving;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface ClientHavingService {

    /**
     * Returns all the {@code ClientHavings}
     * of specified {@code Client}
     *
     * @param client {@code Client}  to get {@code ClientHavings} of
     * @return list of {@code ClientHavings} or {@code null} if found nothing
     */
    List<ClientHaving> getAllByClient(Client client);

    /**
     * Returns all the {@code Clients}
     * that have specified {@code Book}
     *
     * @param book {@code Book} to find
     * @return {@code List} of {@code Clients} or {@code null} if found nothing
     */
    List<Client> getAllClientForBook(Book book);

    /**
     * Returns all {@code Books} of the {@code Client}
     *
     * @param client {@code Client}
     * @return {@code List} of {@code Books}
     */
    List<Book> getAllBooksThatClientHas(Client client);

    /**
     * Deletes {@code ClientHaving} by {@code Client} and {@code Book}
     *
     * @param client {@code Client} to delete {@code ClientHaving} of
     * @param book   {@code Book} to delete
     */
    void deleteClientHaving(Client client, Book book);

    /**
     * Creates new {@code ClientHaving} by {@code Client} and {@code Book}.
     * Returns new entity
     *
     * @param client {@code Client} to create {@code ClientHaving} of
     * @param book   {@code Book} to create {@code ClientHaving} for
     * @return {@code ClientHaving}
     */
    ClientHaving createClientHaving(Client client, Book book);

    /**
     * Adds new {@code ClientHaving} by creating new book
     * and adding it to creating entity.
     *
     * @param client           {@code Client} to create {@code ClientHaving} of
     * @param authorName       {@code Book's} authorName
     * @param authorSurname    {@code Book's} authorSurname
     * @param authorMiddlename {@code Book's} authorMiddlename
     * @param pubhouse         {@code Book's} pubhouse
     * @param pubyear          {@code Book's} pubyear
     * @param description      {@code Book's} description
     * @param bookname         {@code Book's} bookname
     * @return {@code ClientHaving}
     */
    ClientHaving addClientHaving(Client client,
                                 String authorName,
                                 String authorSurname,
                                 String authorMiddlename,
                                 String pubhouse,
                                 String pubyear,
                                 String description,
                                 String bookname);
}
