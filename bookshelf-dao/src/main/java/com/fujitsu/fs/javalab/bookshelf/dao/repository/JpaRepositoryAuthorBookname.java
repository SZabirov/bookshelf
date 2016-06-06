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
     * Returns all {@code AuthorBooknames} from the table
     *
     * @return {@code AuthorBookname} {@code List} or {@code null} if found nothing
     */
    List<AuthorBookname> findAll();

    /**
     * Returns all the {@code AuthorBooknames} from the table
     * with specified {@code Author}
     *
     * @param author {@code Author} to search
     * @return {@code AuthorBookname} {@code List} or {@code null} if found nothing
     */
    List<AuthorBookname> findAllByAuthor(Author author);

    /**
     * Returns all the {@code AuthorBooknames} from the table
     * with specified bookname
     *
     * @param bookname name of book to search
     * @return {@code AuthorBookname} {@code List} or {@code null} if found nothing
     */
    List<AuthorBookname> findAllByBookname(String bookname);

    /**
     * Returns {@code AuthorBookname} with unique {@code Author} and bookname pair
     *
     * @param author   {@code Author} to search
     * @param bookname name of book to search
     * @return {@code AuthorBookname} or {@code null} if found nothing
     */
    AuthorBookname findByAuthorAndBookname(Author author, String bookname);

}
