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
     * Returns all the books from table
     *
     * @return list of authors or null if none was found
     */
    List<Book> findAll();

    /**
     * Returns book by id
     *
     * @param id
     * @return the book or null if nothing was found
     */
    Book findById(int id);

    /**
     * Returns group of books by author and bookname
     * @param authorBookname
     * @return book list or null if none was found
     */
    List<Book> findAllByAuthorBookname(AuthorBookname authorBookname);
}
