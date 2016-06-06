package com.fujitsu.fs.javalab.bookshelf.dao.repository;


import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * Returns all the {@code Books} from the table
     *
     * @return {@code List} of {@code Books} or {@code null} if none was found
     */
    List<Book> findAll();

    /**
     * Returns {@code Book} with specified id
     *
     * @param id unique identifier
     * @return the {@code Book} or {@code null} if nothing was found
     */
    Book findById(int id);

    /**
     * Returns group of {@code Books} by {@code AuthorBookname}
     *
     * @param authorBookname {@code AuthorBookname} to search
     * @return {@code Books} {@code List} or {@code null} if none was found
     */
    List<Book> findAllByAuthorBookname(AuthorBookname authorBookname);
}
