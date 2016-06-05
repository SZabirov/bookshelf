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
     * Returns all the ClientHavings
     * of specified client
     *
     * @param client
     * @return list of ClientHavings or null if found nothing
     */
    List<ClientHaving> getAllByClient(Client client);

    /**
     * Returns all the Clients
     * that have specified book
     *
     * @param book
     * @return list of Clients or null if found nothing
     */
    List<Client> getAllClientForBook(Book book);

    /**
     * Returns all books of the client
     *
     * @param client
     * @return list of Books
     */
    List<Book> getAllBooksThatClientHas(Client client);

    /**
     * Deletes ClientHaving by Client and Book
     *
     * @param client
     * @param book
     */
    void deleteClientHaving(Client client, Book book);

    /**
     * Creates new ClientHaving by client and book.
     * Returns new entity
     *
     * @param client
     * @param book
     * @return ClientHaving
     */
    ClientHaving createClientHaving(Client client, Book book);

    /**
     * Adds new ClientHaving by creating new book
     * and adding it to creating entity.
     *
     * @param client
     * @param authorName
     * @param authorSurname
     * @param authorMiddlename
     * @param pubhouse
     * @param pubyear
     * @param description
     * @param bookname
     * @return ClientHaving
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
