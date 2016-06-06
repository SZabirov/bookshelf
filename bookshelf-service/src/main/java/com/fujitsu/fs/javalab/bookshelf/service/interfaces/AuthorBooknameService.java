package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface AuthorBooknameService {

    /**
     * Returns all the {@code AuthorBookname}
     *
     * @return {@code AuthorBookname} {@code List} or {@code null} if found nothing
     */
    List<AuthorBookname> getAll();

    /**
     * Returns all the {@code AuthorBooknames}
     * with specified {@code Author}
     *
     * @param author {@code Author}
     * @return {@code AuthorBookname} {@code List} or {@code null} if found nothing
     */
    List<AuthorBookname> getAllByAuthor(Author author);

    /**
     * Returns all the {@code AuthorBooknames}
     * with specified bookname
     *
     * @param bookname name of the {@Book}
     * @return {@code AuthorBookname} {@code List} or {@code null} if found nothing
     */
    List<AuthorBookname> getAllByBookname(String bookname);

    /**
     * Returns {@code AuthorBookname} by {@code Author} and bookname
     *
     * @param author {@code Author}
     * @param bookname name of the {@Book}
     * @return {@code AuthorBookname} or {@code null} if found nothing
     */
    AuthorBookname getByAuthorAndBookname(Author author, String bookname);

    /**
     * Saves new {@code AuthorBookname} and returns created entity
     * or if there already is such object then returns
     * existing entity that matches the requested one
     *
     * @param authorBookname {@code AuthorBookname} to save
     * @return created or already existing {@code AuthorBookname}
     */
    AuthorBookname addAuthorBookname(AuthorBookname authorBookname);
}
