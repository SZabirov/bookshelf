package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.service.interfaces.UsersWishService;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import com.fujitsu.fs.javalab.bookshelf.models.UsersWish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fujitsu.fs.javalab.bookshelf.dao.repository.UsersWishRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class UsersWishServiceImpl implements UsersWishService {
@Autowired
    UsersWishRepository usersWishRepository;

    @Override
    public List<UsersWish> getAllUsersWishesForUser(Users users) {
        return usersWishRepository.findAllByUsers(users);
    }

    @Override
    public void deleteUsersWish(Users users, AuthorBookname authorBookname) {
        UsersWish usersWish = usersWishRepository.findOneByUsersAndAuthorBookname(users, authorBookname);
        usersWishRepository.delete(usersWish);
    }

    @Override
    public List<AuthorBookname> getAllBooksThatUserWishes(Users users) {
        List<UsersWish> usersWishes = users.getUsersWishes();
        List<AuthorBookname> authorBooknames = new ArrayList<>();
        for (UsersWish usersWish : usersWishes) {
            authorBooknames.add(usersWish.getAuthorBookname());
        }
        return authorBooknames;
    }
}
