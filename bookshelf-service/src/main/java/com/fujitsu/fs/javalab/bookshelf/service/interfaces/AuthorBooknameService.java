package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface AuthorBooknameService {

    /**
     * Returns all the AuthorBooknames
     *
     * @return AuthorBookname list or null if found nothing
     */
    List<AuthorBookname> getAll();

    /**
     * Returns all the AuthorBooknames
     * with specified Author
     *
     * @param author
     * @return AuthorBookname list or null if found nothing
     */
    List<AuthorBookname> getAllByAuthor(Author author);

    /**
     * Returns all the AuthorBooknames
     * with specified bookname
     *
     * @param bookname
     * @return AuthorBookname list or null if found nothing
     */
    List<AuthorBookname> getAllByBookname(String bookname);

    /**
     * Returns AuthorBookname by author and bookname
     *
     * @param author
     * @param bookname
     * @return AuthorBookname or null if found nothing
     */
    AuthorBookname getByAuthorAndBookname(Author author, String bookname);

    /**
     * Saves new AuthorBookname and returns created entity
     * or if there already is such object then returns
     * existing entity that matches the requested one
     *
     * @param authorBookname
     * @return created or already existing AuthorBookname
     */
    AuthorBookname addAuthorBookname(AuthorBookname authorBookname);
}
