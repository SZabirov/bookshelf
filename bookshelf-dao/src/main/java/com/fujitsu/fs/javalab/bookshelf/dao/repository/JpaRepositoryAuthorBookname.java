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

    AuthorBookname findOneById(int id);

    List<AuthorBookname> findAllByAuthor(Author author);

    List<AuthorBookname> findAllByBookname(String bookname);
// FIXME: 20.05.2016 
//    List<AuthorBookname> findAllWhereVerifiedIsTrue();
//
//    List<AuthorBookname> findAllWhereVerifiedIsFalse();

    //???
//    List<AuthorBookname> findAllWhereVerifiedIsTrueByAuthor(Author author);

}
