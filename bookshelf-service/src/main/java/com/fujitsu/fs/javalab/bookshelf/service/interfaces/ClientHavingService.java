package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientHaving;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface ClientHavingService {

    List<ClientHaving> getAllByClient(Client client);

    List<Client> getAllClientForBook(Book book);

    List<Book> getAllBooksThatClientHas(Client client);

    void deleteClientHaving(Client client, Book book);

    ClientHaving createClientHaving(Client client, Book book);

    ClientHaving addClientHaving(Client client,
                               String authorName,
                               String authorSurname,
                               String authorMiddlename,
                               String pubhouse,
                               String pubyear,
                               String description,
                               String bookname);
}
