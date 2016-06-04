package com.fujitsu.fs.javalab.bookshelf.web.security;

import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientService clientService;

    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException, DataAccessException {
        System.out.println("Hello from UserDetailsService! Login " + login);

        Client client = clientService.getClientByNickname(login);
        System.out.println("Client   -  " + client.getNickname());
        System.out.println(client.getHashpassword());
//        if (client == null) {
//            throw new ClientnameNotFoundException("Email is not found in the database");
//        }

        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority("USER"));

        // на основании полученныйх даных формируем объект ClientDetails
        // который позволит проверить введеный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        UserDetails clientDetails = new org.springframework.security.core.userdetails.User(client.getNickname(),
                client.getHashpassword(), roles);
        return clientDetails;

    }

}
