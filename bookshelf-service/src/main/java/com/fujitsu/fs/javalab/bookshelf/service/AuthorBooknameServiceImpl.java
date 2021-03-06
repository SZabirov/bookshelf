package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.JpaRepositoryAuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorBooknameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class AuthorBooknameServiceImpl implements AuthorBooknameService {

    @Autowired
    JpaRepositoryAuthorBookname jpaRepositoryAuthorBookname;

    @Override
    public List<AuthorBookname> getAll() {
        return jpaRepositoryAuthorBookname.findAll();
    }

    @Override
    public List<AuthorBookname> getAllByAuthor(Author author) {
        return jpaRepositoryAuthorBookname.findAllByAuthor(author);
    }

    @Override
    public List<AuthorBookname> getAllByBookname(String bookname) {
        return jpaRepositoryAuthorBookname.findAllByBookname(bookname);
    }

    @Override
    public AuthorBookname getByAuthorAndBookname(Author author, String bookname) {
        return jpaRepositoryAuthorBookname.findByAuthorAndBookname(author, bookname);
    }

    @Override
    public AuthorBookname addAuthorBookname(AuthorBookname authorBookname) {
        AuthorBookname foundAuthorBookname = jpaRepositoryAuthorBookname.findByAuthorAndBookname(authorBookname.getAuthor(),
                authorBookname.getBookname());
        if (foundAuthorBookname == null) {
            foundAuthorBookname =  jpaRepositoryAuthorBookname.save(authorBookname);
        }
        return foundAuthorBookname;
    }

}
