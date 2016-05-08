package service.interfaces;

import model.AuthorBookname;
import model.Users;
import model.UsersWish;
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
