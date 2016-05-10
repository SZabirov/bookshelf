package com.fujitsu.fs.javalab.bookshelf;


import com.fujitsu.fs.javalab.bookshelf.interfaces.AuthorBooknameService;
import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AuthorBooknameRepository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class AuthorBooknameServiceImpl implements AuthorBooknameService {

    @Autowired
    AuthorBooknameRepository authorBooknameRepository;


    @Override
    public List<AuthorBookname> getAll() {
        return authorBooknameRepository.findAll();
    }

    @Override
    public List<AuthorBookname> getAllByAuthor(Author author) {
        return authorBooknameRepository.findAllByAuthor(author);
    }

    @Override
    public List<AuthorBookname> getAllByBookname(String bookname) {
        return authorBooknameRepository.findAllByBookname(bookname);
    }

    @Override
    public List<AuthorBookname> getAllVerifiedBooksForAuthor(Author author) {
        return authorBooknameRepository.findAllWhereVerifiedIsTrueByAuthor(author);
    }
}
