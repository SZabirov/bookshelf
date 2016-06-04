package com.fujitsu.fs.javalab.bookshelf.dao.repository;


import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import com.fujitsu.fs.javalab.bookshelf.models.UsersHaving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface UsersHavingRepository extends JpaRepository<UsersHaving, Integer> {

    List<UsersHaving> findAll();

    List<UsersHaving> findAllByUsers(Users users);

    List<UsersHaving> findAllByBook(Book book);

    UsersHaving findByUsersAndBook(Users users, Book book);
}
