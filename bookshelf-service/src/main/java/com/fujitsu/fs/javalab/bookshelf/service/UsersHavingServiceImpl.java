package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.UsersHavingRepository;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.UsersHavingService;
import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import com.fujitsu.fs.javalab.bookshelf.models.UsersHaving;
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
}
