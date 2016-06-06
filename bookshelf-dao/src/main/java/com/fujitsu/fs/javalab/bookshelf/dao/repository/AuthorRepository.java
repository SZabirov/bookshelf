package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    /**
     * Returns all the {@code Authors} from table
     *
     * @return {@code List} of {@code Authors} or {@code null} if none was found
     */
    List<Author> findAll();

    /**
     * Returns {@code Author} by id
     *
     * @param id the identifier of the object
     * @return the {@code Author} or {@code null} if nothing was found
     */
    Author findById(int id);

    /**
     * Returns all the {@code Authors} by firstname and surname
     *
     * @param firstname {@code Author's} firstname
     * @param surname   {@code Author's} surname
     * @return the {@code Authors} or {@code null} if none was found
     */
    List<Author> findAllByFirstnameAndSurname(String firstname, String surname);

    /**
     * Returns {@code Author} by firstname, surname and middlename
     *
     * @param firstname  {@code Author's} firstname
     * @param surname    {@code Author's} surname
     * @param middlename {@code Author's} middlename
     * @return the {@code Author} or {@code null} if none was found
     */
    Author findByFirstnameAndSurnameAndMiddlename(String firstname, String surname, String middlename);

}
