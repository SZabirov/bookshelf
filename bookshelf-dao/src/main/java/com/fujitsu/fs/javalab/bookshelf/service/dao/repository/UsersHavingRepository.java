package com.fujitsu.fs.javalab.bookshelf.service.dao.repository;


import com.fujitsu.fs.javalab.bookshelf.service.models.Book;
import com.fujitsu.fs.javalab.bookshelf.service.models.Users;
import com.fujitsu.fs.javalab.bookshelf.service.models.UsersHaving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface UsersHavingRepository extends JpaRepository<UsersHaving, Integer> {

    List<UsersHaving> findAll();

    UsersHaving findOneById(int id);

    List<UsersHaving> findAllByUsers(Users users);

    List<UsersHaving> findAllByBook(Book book);

    UsersHaving findOneByUsersAndBook(Users users, Book book);
}
