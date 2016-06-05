package com.fujitsu.fs.javalab.bookshelf.dao.repository;


import com.fujitsu.fs.javalab.bookshelf.models.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AuthorBooknameRepositoryTest {

    private static JpaRepositoryAuthorBookname authorBooknameRepository;
    private static AuthorRepository authorRepository;

    @BeforeClass
    public static void prepareData() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("repository-config.xml");
        authorBooknameRepository = ctx.getBean(JpaRepositoryAuthorBookname.class);
        authorRepository = ctx.getBean(AuthorRepository.class);
    }

    @Test
    public void findAllMethodShouldReturnNotEmptyList() {
        Assert.assertNotNull(authorBooknameRepository.findAll());
    }

    @Test
    public void findAllByAuthorMethodShouldReturnListOfHaving() {
        Author author = authorRepository.getOne(3);
        List<AuthorBookname> books = authorBooknameRepository.findAllByAuthor(author);
        Assert.assertEquals(books.size(), 2);
    }

    @Test
    public void findAllByBooknameMethodShouldReturnListOfHaving() {
        List<AuthorBookname> books = authorBooknameRepository.findAllByBookname("Война и Мир");
        Assert.assertEquals(books.get(0).getId(), 1);
    }

    @Test
    public void findAllByAuthorAndBooknameMethodShouldReturnListOfHaving() {
        Author author = authorRepository.getOne(3);
        AuthorBookname authorBookname = authorBooknameRepository.findByAuthorAndBookname(author, "Дворянское гнездо");
        Assert.assertEquals(authorBookname.getId(), 4);
    }

}
