package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Author;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface AuthorService {

    /**
     * Returns one {@code Author} by ID
     *
     * @param id the identifier of the object
     * @return the {@code Author} or {@code null} if nothing was found
     */
    Author getAuthorById(int id);

    /**
     * Returns all the {@code Authors}
     *
     * @return {@code List} of {@code Authors} or {@code null} if none was found
     */
    List<Author> getAll();

    /**
     * Returns all the {@code Authors} by firstname and surname
     *
     * @param firstname {@code Author's} firstname
     * @param surname   {@code Author's} surname
     * @return the {@code Authors} or {@code null} if none was found
     */
    List<Author> getAllAuthorByFirstnameAndSurname(String firstname, String surname);

    /**
     * Returns {@code Author} by firstname, surname and middlename
     *
     * @param firstname  {@code Authors} firstname
     * @param surname    {@code Authors} surname
     * @param middlename {@code Authors} middlename
     * @return {@code List} of the {@code Authors} or {@code null} if none was found
     */
    Author getAuthorByFirstnameAndSurnameAndMiddlename(String firstname, String surname, String middlename);

    /**
     * Saves new {@code Author} and returns created entity
     * or returns existing one in case of containing such {@code Author}
     *
     * @param author {@code Author} to add
     * @return {@code Author}
     */
    Author addAuthor(Author author);
}
