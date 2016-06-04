package com.fujitsu.fs.javalab.bookshelf.dao.repository;


import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface JpaRepositoryAuthorBookname extends JpaRepository<AuthorBookname, Integer> {

    /**
     * Returns all AuthorBooknames from the table
     *
     * @return AuthorBookname list
     */
    List<AuthorBookname> findAll();

    /**
     * Returns all the AuthorBooknames from the table
     * with specified Author
     *
     * @param author
     * @return AuthorBookname list
     */
    List<AuthorBookname> findAllByAuthor(Author author);

    /**
     * Returns all the AuthorBooknames from the table
     * with specified bookname
     *
     * @param bookname
     * @return AuthorBookname list
     */
    List<AuthorBookname> findAllByBookname(String bookname);

    /**
     * Returns AuthorBookname with unique author and bookname pair
     * @param author
     * @param bookname
     * @return AuthorBookname
     */
    AuthorBookname findByAuthorAndBookname(Author author, String bookname);

}
