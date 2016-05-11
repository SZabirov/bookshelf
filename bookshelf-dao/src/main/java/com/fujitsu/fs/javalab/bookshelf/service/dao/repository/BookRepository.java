package com.fujitsu.fs.javalab.bookshelf.service.dao.repository;


import com.fujitsu.fs.javalab.bookshelf.service.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.service.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAll();

    Book findOneById(int id);

    List<Book> findAllByAuthorBookname(AuthorBookname authorBookname);

    List<Book> findAllByPubhouse(String pubhouse);

    List<Book> findAllByPubYear(String pubYear);

    List<Book> findAllWhereVerifiedIsTrue();

    List<Book> findAllWhereVerifiedIsFalse();
}