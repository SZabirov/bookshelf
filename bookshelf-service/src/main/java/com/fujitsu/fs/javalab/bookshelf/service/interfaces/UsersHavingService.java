package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import com.fujitsu.fs.javalab.bookshelf.models.UsersHaving;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
//@Service
public interface UsersHavingService {

    List<UsersHaving> getAllByUser(Users users);

    List<Users> getAllUsersHavingsForBook(Book book);

    List<Book> getAllBooksThatUserHas(Users users);

    void deleteUsersHaving(Users users, Book book);

    UsersHaving createUsersHaving(Users users, Book book);

    UsersHaving addUsersHaving(Users users,
                               String authorName,
                               String authorSurname,
                               String authorMiddlename,
                               String pubhouse,
                               String pubyear,
                               String description,
                               String bookname);
}
