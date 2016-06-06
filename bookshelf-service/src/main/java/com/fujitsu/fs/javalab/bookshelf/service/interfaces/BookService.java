package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Book;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface BookService {

    /**
     * Returns all the existing {@code Books}
     *
     * @return {@code List} of {@code Authors} or {@code null} if none was found
     */
    List<Book> getAll();

    /**
     * Returns all {@code Books} with specified AuthorBookname
     *
     * @param authorBookname {@code AuthorBookname} to get for
     * @return {@code List} of {@code Books}
     */
    List<Book> getBooksByAuthorBookname(AuthorBookname authorBookname);

    /**
     * Returns {@code Book} by ID
     *
     * @param id unique identifier
     * @return {@code Book}
     */
    Book getById(int id);

    /**
     * Adds new {@code Book} and returns created entity
     *
     * @param book {@code Book} to add
     * @return {@code Books}
     */
    Book addBook(Book book);
}
