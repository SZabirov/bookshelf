package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.BookRepository;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getByPubhouse(String pubhouse) {
        return bookRepository.findAllByPubhouse(pubhouse);
    }

    @Override
    public List<Book> getByPubYear(String pubYear) {
        return bookRepository.findAllByPubYear(pubYear);
    }

    @Override
    public boolean ifBookIsVerified(int id) {
        return bookRepository.findOneById(id).getVerified();
    }

    @Override
    public List<Book> getBooksByAuthorBookname(AuthorBookname authorBookname) {
        return bookRepository.findAllByAuthorBookname(authorBookname);
    }

    @Override
    public List<Book> getAllVerifiedBooks() {
        return bookRepository.findAllWhereVerifiedIsTrue();
    }
}
