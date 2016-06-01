package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Author;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface AuthorService {

    Author getAuthorById(int id);

    List<Author> getAll();

    Author getAuthorByFirstnameAndSurname(String firstname, String surname);

    Author getAuthorByFirstnameAndSurnameAndMiddlename(String firstname, String surname, String middlename);

    Author addAuthor(Author author);
}
