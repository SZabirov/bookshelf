package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.UsersWishRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import com.fujitsu.fs.javalab.bookshelf.models.UsersWish;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorBooknameService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.UsersWishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class UsersWishServiceImpl implements UsersWishService {
    @Autowired
    UsersWishRepository usersWishRepository;
    @Autowired
    AuthorBooknameService authorBooknameService;
    @Autowired
    AuthorService authorService;

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

    @Override
    public UsersWish addUsersWish(Users users, AuthorBookname authorBookname) {
        UsersWish usersWish = new UsersWish();
        usersWish.setAuthorBookname(authorBookname);
        usersWish.setUsers(users);
        UsersWish createdUsersWish = usersWishRepository.save(usersWish);
        return (usersWish);
    }

    @Override
    public UsersWish addWishing(String authorName, String authorSurname, String authorMiddlename, String bookname, Users users) {
        Author author = authorService.getAuthorByFirstnameAndSurnameAndMiddlename(authorName, authorSurname, authorMiddlename);
        if (author == null) {
            author = new Author();
            author.setFirstname(authorName);
            author.setSurname(authorSurname);
            author.setMiddlename(authorMiddlename);
            author = authorService.addAuthor(author);
        }
        AuthorBookname authorBookname = authorBooknameService.getOneByAuthorAndBookname(author, bookname);
        if (authorBookname == null) {
            authorBookname = new AuthorBookname();
            authorBookname.setAuthor(author);
            authorBookname.setBookname(bookname);
            authorBookname = authorBooknameService.addAuthorBookname(authorBookname);
        }
        UsersWish usersWish = usersWishRepository.findOneByUsersAndAuthorBookname(users, authorBookname);
        if (usersWish == null) {
            return addUsersWish(users, authorBookname);
        } else {
            return usersWish;
        }
    }

    @Override
    public void deleteById(Integer id) {
        UsersWish usersWish = usersWishRepository.findOneById(id);
        usersWishRepository.delete(usersWish);
    }
}
