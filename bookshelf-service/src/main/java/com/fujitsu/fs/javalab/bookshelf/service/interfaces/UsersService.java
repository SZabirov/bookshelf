package com.fujitsu.fs.javalab.bookshelf.service.interfaces;

import com.fujitsu.fs.javalab.bookshelf.models.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public interface UsersService {

    void addNewUsers(String nickname, String email, String firstname, String surname,
                     String city, String hashpassword, String avatar);

    void updateUser(int id, String new_nickname, String new_email, String new_firstname,
                    String new_surname, String new_city, String old_hashpassword, String new_hashpassword,
                    String new_avatar);

    boolean ifCorrectUser(int id, String hashpassword);

    boolean ifCorrectUser(String nickname, String hashpassword);

    List<Users> getAllUsersByCity(String city);

    Users getUserById(int id);

    List<Users> getAll();

    List<Users> getAllUsersOrderBySurnameAndFirstname();

    Users getUsersByNickname(String nickname);

    boolean ifNicknameExists(String nickname);
}
