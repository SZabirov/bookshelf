package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.service.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.service.models.Users;
import com.fujitsu.fs.javalab.bookshelf.service.models.UsersWish;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public interface UsersWishService {

    List<UsersWish> getAllUsersWishesForUser(Users users);

    void deleteUsersWish(Users users, AuthorBookname authorBookname);

    List<AuthorBookname> getAllBooksThatUserWishes(Users users);  //AuthorBookname list, that User wishes


}