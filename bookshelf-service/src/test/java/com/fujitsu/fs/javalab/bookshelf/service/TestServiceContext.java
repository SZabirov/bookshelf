package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.*;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ={"com.fujitsu.fs.javalab.bookshelf.service", "com.fujitsu.fs.javalab.bookshelf.dao.repository"})
public class TestServiceContext {

//    @Bean
//    public BookRepository bookRepository(){
//        return Mockito.mock(BookRepository.class);
//    }
//
//    @Bean
//    public JpaRepositoryAuthorBookname authorBooknameRepository(){
//        return Mockito.mock(JpaRepositoryAuthorBookname.class);
//    }
//
//    @Bean
//    public TokenRepository tokenRepository(){
//        return Mockito.mock(TokenRepository.class);
//    }
//
//    @Bean
//    public ClientHavingRepository clientHavingRepository(){
//        return Mockito.mock(ClientHavingRepository.class);
//    }
//
//    @Bean
//    public JpaRepositoryClient clientRepository(){
//        return Mockito.mock(JpaRepositoryClient.class);
//    }
//
//    @Bean
//    public ClientWishRepository clientWishRepository(){
//        return Mockito.mock(ClientWishRepository.class);
//    }
}
