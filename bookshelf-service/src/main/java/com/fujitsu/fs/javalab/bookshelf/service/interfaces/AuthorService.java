package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Author;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface AuthorService {

    /**
     * Returns only one author by id
     *
     * @param id the identifier of the object
     * @return the author or null if nothing was found
     */
    Author getAuthorById(int id);

    /**
     * Returns all the authors
     *
     * @return list of authors or null if none was found
     */
    List<Author> getAll();

    /**
     * Returns all the authors by firstname and surname
     *
     * @param firstname
     * @param surname
     * @return the authors or null if none was found
     */
    List<Author> getAllAuthorByFirstnameAndSurname(String firstname, String surname);

    /**
     * Returns author by firstname, surname and middlename
     *
     * @param firstname
     * @param surname
     * @param middlename
     * @return the author or null if none was found
     */
    Author getAuthorByFirstnameAndSurnameAndMiddlename(String firstname, String surname, String middlename);

    /**
     * Saves new Author and returns created entity
     * or returns existing one in case of containing such Author
     *
     * @param author
     * @return
     */
    Author addAuthor(Author author);
}
