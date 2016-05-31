package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public interface BookService {

    List<Book> getAll();

    List<Book> getByPubhouse(String pubhouse);

    List<Book> getByPubYear(String pubYear);

    boolean ifBookIsVerified(int id);

    List<Book> getBooksByAuthorBookname(AuthorBookname authorBookname);

    List<Book> getAllVerifiedBooks();

    Book getById(int id);
}
