package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.AuthorRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthorByFirstnameAndSurname(String firstname, String surname) {
        return authorRepository.findAllByFirstnameAndSurname(firstname, surname);
    }

    @Override
    public Author getAuthorByFirstnameAndSurnameAndMiddlename(String firstname, String surname, String middlename) {
        return authorRepository.findByFirstnameAndSurnameAndMiddlename(firstname, surname, middlename);
    }

    @Override
    public Author addAuthor(Author author) {
        Author existingAuthor = getAuthorByFirstnameAndSurnameAndMiddlename(author.getFirstname(),
                author.getSurname(), author.getMiddlename());
        if (existingAuthor == null) {
            return authorRepository.save(author);
        } else {
            return existingAuthor;
        }
    }

}
