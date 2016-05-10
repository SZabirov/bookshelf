package service;

import model.AuthorBookname;
import model.Users;
import model.UsersWish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UsersWishRepository;
import service.interfaces.UsersWishService;

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
