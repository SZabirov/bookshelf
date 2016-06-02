package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.UsersHavingRepository;
import com.fujitsu.fs.javalab.bookshelf.models.*;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorBooknameService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.BookService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.UsersHavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class UsersHavingServiceImpl implements UsersHavingService {

    @Autowired
    UsersHavingRepository usersHavingRepository;
    @Autowired
    AuthorBooknameService authorBooknameService;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @Override
    public List<UsersHaving> getAllByUser(Users users) {
        return usersHavingRepository.findAllByUsers(users);
    }

    @Override
    public List<Users> getAllUsersHavingsForBook(Book book) {
        List<UsersHaving> usersHavings = usersHavingRepository.findAllByBook(book);
        List<Users> users = new ArrayList<>();
        for (UsersHaving usersHaving : usersHavings) {
            users.add(usersHaving.getUsers());
        }
        return users;
    }

    @Override
    public List<Book> getAllBooksThatUserHas(Users users) {
        List<UsersHaving> usersHavings = users.getUsersHavings();
        List<Book> books = new ArrayList<>();
        for (UsersHaving usersHaving : usersHavings) {
            books.add(usersHaving.getBook());
        }
        return books;
    }

    @Override
    public void deleteUsersHaving(Users users, Book book) {
        UsersHaving usersHaving = usersHavingRepository.findOneByUsersAndBook(users, book);
        usersHavingRepository.delete(usersHaving);
    }

    @Override
    public UsersHaving createUsersHaving(Users users, Book book) {
        UsersHaving usersHaving = new UsersHaving();
        usersHaving.setUsers(users);
        usersHaving.setBook(book);
        return usersHavingRepository.save(usersHaving);
    }

    @Override
    public UsersHaving addUsersHaving(Users users, String authorName, String authorSurname, String authorMiddlename, String pubhouse, String pubyear, String description, String bookname) {
        Author author = authorService.getAuthorByFirstnameAndSurnameAndMiddlename(authorName, authorSurname, authorMiddlename);
        if (author == null) {
            author = new Author();
            author.setFirstname(authorName);
            author.setSurname(authorSurname);
            author.setMiddlename(authorMiddlename);
            author = authorService.addAuthor(author);
        }
        AuthorBookname authorBookname = authorBooknameService.getOneByAuthorAndBookname(author, bookname);
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
        return createUsersHaving(users, book);
    }

    public UsersHavingRepository getUsersHavingRepository() {
        return usersHavingRepository;
    }

    public void setUsersHavingRepository(UsersHavingRepository usersHavingRepository) {
        this.usersHavingRepository = usersHavingRepository;
    }
}
