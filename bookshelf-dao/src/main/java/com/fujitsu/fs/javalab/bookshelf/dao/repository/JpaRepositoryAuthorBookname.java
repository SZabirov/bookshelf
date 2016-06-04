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

    List<AuthorBookname> findAll();

    List<AuthorBookname> findAllByAuthor(Author author);

    List<AuthorBookname> findAllByBookname(String bookname);

    List<AuthorBookname> findAllByAuthorAndBookname(Author author, String bookname);

    AuthorBookname findByAuthorAndBookname(Author author, String bookname);

}
