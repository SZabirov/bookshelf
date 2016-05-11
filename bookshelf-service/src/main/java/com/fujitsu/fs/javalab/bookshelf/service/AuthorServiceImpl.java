package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorService;
import com.fujitsu.fs.javalab.bookshelf.service.models.Author;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
// TODO: 11.05.2016 add realization to all the methods!
@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public Author getAuthorById(int id) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public Author getAuthorByFirstnameAndSurname(String firstname, String surname) {
        return null;
    }
}
