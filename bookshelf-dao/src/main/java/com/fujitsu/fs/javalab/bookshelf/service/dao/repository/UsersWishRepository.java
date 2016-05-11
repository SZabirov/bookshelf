package com.fujitsu.fs.javalab.bookshelf.service.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.service.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.service.models.Users;
import com.fujitsu.fs.javalab.bookshelf.service.models.UsersWish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface UsersWishRepository extends JpaRepository<UsersWish, Integer> {

    List<UsersWish> findAll();

    UsersWish findOneById(int id);

    UsersWish findOneByUsersAndAuthorBookname(Users users, AuthorBookname authorBookname);

    List<UsersWish> findAllByUsers(Users users);

    List<UsersWish> findAllByAuthorBookname(AuthorBookname authorBookname);
}