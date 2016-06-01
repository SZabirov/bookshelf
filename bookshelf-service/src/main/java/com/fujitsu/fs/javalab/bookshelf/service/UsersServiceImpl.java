package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.JpaRepositoryUsers;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    JpaRepositoryUsers jpaRepositoryUsers;

    @Override
    public void addNewUsers(String nickname, String email, String firstname, String surname,
                            String city, String hashpassword, String avatar) {
        Users users = new Users();
        users.setNickname(nickname);
        users.setEmail(email);
        users.setFirstname(firstname);
        users.setSurname(surname);
        users.setCity(city);
        users.setHashpassword(hashpassword);
        users.setAvatar(avatar);
        jpaRepositoryUsers.save(users);
    }

    @Override
    public void updateUser(int id, String new_nickname, String new_email, String new_firstname,
                           String new_surname, String new_city, String old_hashpassword, String new_hashpassword,
                           String new_avatar) {
        Users users = jpaRepositoryUsers.findOneById(id);
        if (new_nickname != null && !new_nickname.equals("")) {
            users.setNickname(new_nickname);
        }
        if (new_email != null && !new_email.equals("")) {
            users.setEmail(new_email);
        }
        if (new_firstname != null && !new_firstname.equals("")) {
            users.setFirstname(new_firstname);
        }
        if (new_surname != null && !new_surname.equals("")) {
            users.setSurname(new_surname);
        }
        if (new_city != null && !new_city.equals("")) {
            users.setCity(new_city);
        }
        if (ifCorrectUser(id, old_hashpassword)) {
            if (new_hashpassword != null && !new_hashpassword.equals("")) {
                users.setHashpassword(new_hashpassword);
            }
        } else {
            //FIXME:do smth with old password - check it or not?
            System.out.println("Wrong old password");
            return;
        }
        if (new_avatar != null && !new_avatar.equals("")) {
            users.setAvatar(new_avatar);
        }

    }

    @Override
    public boolean ifCorrectUser(int id, String hashpassword) {
        Users users = jpaRepositoryUsers.findOneById(id);
        return users.getHashpassword().equals(hashpassword);
    }

    @Override
    public boolean ifCorrectUser(String nickname, String hashpassword) {
        Users users = jpaRepositoryUsers.findOneByNickname(nickname);
        return users.getHashpassword().equals(hashpassword);
    }

    @Override
    public List<Users> getAllUsersByCity(String city) {
        return jpaRepositoryUsers.findAllByCity(city);
    }

    @Override
    public Users getUserById(int id) {
        return jpaRepositoryUsers.findOneById(id);
    }

    @Override
    public List<Users> getAll() {
        return jpaRepositoryUsers.findAll();
    }

    // FIXME: 20.05.2016 
    @Override
    public List<Users> getAllUsersOrderBySurnameAndFirstname() {
        return null;
//        return usersRepository.findAllOrderbySurnameAndFirstname();
    }

    @Override
    public Users getUsersByNickname(String nickname) {
        System.out.println("Getting user by name " + nickname);
        Users user = jpaRepositoryUsers.findOneByNickname(nickname);
        System.out.println("In service got user " + user );
        return user;
    }

    @Override
    public boolean ifNicknameExists(String nickname) {
        Users users = jpaRepositoryUsers.findOneByNickname(nickname);
        return users != null;
    }

    @Override
    public Users getUsersByEmail(String email) {
        return jpaRepositoryUsers.findOneByEmail(email);
    }


    @Override
    public boolean ifEmailExists(String email) {
        Users users = jpaRepositoryUsers.findOneByEmail(email);
        return users != null;
    }
}
