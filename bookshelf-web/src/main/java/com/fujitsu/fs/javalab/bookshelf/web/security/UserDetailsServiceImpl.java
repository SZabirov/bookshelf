package com.fujitsu.fs.javalab.bookshelf.web.security;

import com.fujitsu.fs.javalab.bookshelf.models.Users;
import com.fujitsu.fs.javalab.bookshelf.service.UsersServiceImpl;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UsersService usersService;

    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException, DataAccessException {
        usersService = new UsersServiceImpl();
        Users user = usersService.getUsersByNickname(login);
        System.out.println("User***** " + user.getNickname());
        System.out.println(user.getHashpassword());
//        if (user == null) {
//            throw new UsernameNotFoundException("Email is not found in the database");
//        }

        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority("CLIENT"));

        // на основании полученныйх даных формируем объект UserDetails
        // который позволит проверить введеный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getNickname(),
                user.getHashpassword(), roles);
        return userDetails;

    }

}
