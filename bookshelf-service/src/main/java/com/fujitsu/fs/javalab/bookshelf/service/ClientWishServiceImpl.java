package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.ClientWishRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientWish;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorBooknameService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.ClientWishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class ClientWishServiceImpl implements ClientWishService {
    @Autowired
    ClientWishRepository clientWishRepository;
    @Autowired
    AuthorBooknameService authorBooknameService;
    @Autowired
    AuthorService authorService;

    @Override
    public ClientWish addClientWish(Client client, AuthorBookname authorBookname) {
        ClientWish clientWish = new ClientWish();
        clientWish.setAuthorBookname(authorBookname);
        clientWish.setClient(client);
        ClientWish createdClientWish = clientWishRepository.save(clientWish);
        return (clientWish);
    }

    @Override
    public ClientWish addWishing(String authorName, String authorSurname, String authorMiddlename, String bookname, Client client) {
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
        ClientWish clientWish = clientWishRepository.findByClientAndAuthorBookname(client, authorBookname);
        if (clientWish == null) {
            return addClientWish(client, authorBookname);
        } else {
            return clientWish;
        }
    }

    @Override
    public void deleteById(Integer id) {
        ClientWish clientWish = clientWishRepository.findById(id);
        clientWishRepository.delete(clientWish);
    }
}
