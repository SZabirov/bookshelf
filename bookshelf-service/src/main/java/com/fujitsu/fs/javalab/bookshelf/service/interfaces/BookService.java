package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Book;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface BookService {

    List<Book> getAll();

    boolean ifBookIsVerified(int id);

    List<Book> getBooksByAuthorBookname(AuthorBookname authorBookname);

    Book getById(int id);

    Book addBook(Book book);
}
