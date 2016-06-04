package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.ClientHavingRepository;
import com.fujitsu.fs.javalab.bookshelf.models.*;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorBooknameService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.BookService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.ClientHavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class ClientHavingServiceImpl implements ClientHavingService {

    @Autowired
    ClientHavingRepository clientHavingRepository;
    @Autowired
    AuthorBooknameService authorBooknameService;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @Override
    public List<ClientHaving> getAllByClient(Client client) {
        return clientHavingRepository.findAllByClient(client);
    }

    @Override
    public List<Client> getAllClientForBook(Book book) {
        List<ClientHaving> clientHavings = clientHavingRepository.findAllByBook(book);
        List<Client> client = new ArrayList<>();
        if (clientHavings == null) {
            return null;
        }
        for (ClientHaving clientHaving : clientHavings) {
            client.add(clientHaving.getClient());
        }
        return client;
    }

    @Override
    public List<Book> getAllBooksThatClientHas(Client client) {
        List<ClientHaving> clientHavings = clientHavingRepository.findAllByClient(client);
        List<Book> books = new ArrayList<>();
        if (clientHavings == null) {
            return null;
        }
        for (ClientHaving clientHaving : clientHavings) {
            books.add(clientHaving.getBook());
        }
        return books;
    }

    @Override
    public void deleteClientHaving(Client client, Book book) {
        ClientHaving clientHaving = clientHavingRepository.findByClientAndBook(client, book);
        clientHavingRepository.delete(clientHaving);
    }

    @Override
    public ClientHaving createClientHaving(Client client, Book book) {
        ClientHaving clientHaving = new ClientHaving();
        clientHaving.setClient(client);
        clientHaving.setBook(book);
        return clientHavingRepository.save(clientHaving);
    }

    @Override
    public ClientHaving addClientHaving(Client client, String authorName, String authorSurname, String authorMiddlename, String pubhouse, String pubyear, String description, String bookname) {
        Author author = authorService.getAuthorByFirstnameAndSurnameAndMiddlename(authorName, authorSurname, authorMiddlename);
        if (author == null) {
            author = new Author();
            author.setFirstname(authorName);
            author.setSurname(authorSurname);
            author.setMiddlename(authorMiddlename);
            author = authorService.addAuthor(author);
        }
        AuthorBookname authorBookname = authorBooknameService.getByAuthorAndBookname(author, bookname);
        if (authorBookname == null) {
            authorBookname = new AuthorBookname();
            authorBookname.setAuthor(author);
            authorBookname.setBookname(bookname);
            authorBookname = authorBooknameService.addAuthorBookname(authorBookname);
        }
        Book book = new Book();
        book.setAuthorBookname(authorBookname);
        book.setDescription(description);
        book.setPubhouse(pubhouse);
        book.setPubYear(pubyear);
        book = bookService.addBook(book);
        return createClientHaving(client, book);
    }

}
