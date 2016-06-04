package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface AuthorBooknameService {
    /**
     *
     * @return
     */
    List<AuthorBookname> getAll();

    List<AuthorBookname> getAllByAuthor(Author author);

    List<AuthorBookname> getAllByBookname(String bookname);

    AuthorBookname getByAuthorAndBookname(Author author, String bookname);

    AuthorBookname addAuthorBookname(AuthorBookname authorBookname);
}
