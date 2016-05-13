package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.*;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ={"com.fujitsu.fs.javalab.bookshelf", "com.fujitsu.fs.javalab.bookshelf.dao.repository"})
public class TestServiceContext {

    @Bean
    public BookRepository bookRepository(){
        return Mockito.mock(BookRepository.class);
    }

    @Bean
    public AuthorBooknameRepository authorBooknameRepository(){
        return Mockito.mock(AuthorBooknameRepository.class);
    }

    @Bean
    public TokenRepository tokenRepository(){
        return Mockito.mock(TokenRepository.class);
    }

    @Bean
    public UsersHavingRepository usersHavingRepository(){
        return Mockito.mock(UsersHavingRepository.class);
    }

    @Bean
    public UsersRepository usersRepository(){
        return Mockito.mock(UsersRepository.class);
    }

    @Bean
    public UsersWishRepository usersWishRepository(){
        return Mockito.mock(UsersWishRepository.class);
    }
}
