package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Book;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface BookService {

    /**
     * Returns all the existing books
     *
     * @return list of authors or null if none was found
     */
    List<Book> getAll();

    /**
     * Returns all books with specified AuthorBookname
     *
     * @param authorBookname
     * @return list of Books
     */
    List<Book> getBooksByAuthorBookname(AuthorBookname authorBookname);

    /**
     * Returns Book by id
     *
     * @param id unique identifier
     * @return Book
     */
    Book getById(int id);

    /**
     * Adds new Book and returns created entity
     *
     * @param book
     * @return Book
     */
    Book addBook(Book book);
}
