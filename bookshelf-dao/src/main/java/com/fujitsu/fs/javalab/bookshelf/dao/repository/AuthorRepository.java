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
     * Returns all the authors from table
     *
     * @return list of authors or null if none was found
     */
    List<Author> findAll();

    /**
     * Returns only one author by id
     *
     * @param id the identifier of the object
     * @return the author or null if nothing was found
     */
    Author findById(int id);

    /**
     * Returns all the authors by firstname and surname
     *
     * @param firstname
     * @param surname
     * @return the authors or null if none was found
     */
    List<Author> findAllByFirstnameAndSurname(String firstname, String surname);

    /**
     * Returns author by firstname, surname and middlename
     *
     * @param firstname
     * @param surname
     * @param middlename
     * @return the author or null if none was found
     */
    Author findByFirstnameAndSurnameAndMiddlename(String firstname, String surname, String middlename);

}
