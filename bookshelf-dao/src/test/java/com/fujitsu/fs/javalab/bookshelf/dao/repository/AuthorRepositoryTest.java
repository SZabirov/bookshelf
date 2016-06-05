package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Author;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class AuthorRepositoryTest {

    private static AuthorRepository authorRepository;

    @BeforeClass
    public static void prepareData() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("repository-config.xml");
        authorRepository = ctx.getBean(AuthorRepository.class);
    }

    @Test
    public void findAllMethodShouldReturnNotEmptyList() {
        Assert.assertNotNull(authorRepository.findAll());
    }

    @Test
    public void findByIdMethodShouldReturnAuthor() {
        Author author1 = authorRepository.findById(1);
        Assert.assertEquals(author1.getId(), 1);
    }

    @Test
    public void findByFirstnameAndSurnameMethodShouldReturnAuthor() {
        List<Author> authors1 = authorRepository.findAllByFirstnameAndSurname("Лев", "Толстой");
        Assert.assertEquals(authors1.get(0).getFirstname(), "Лев");
        Assert.assertEquals(authors1.get(0).getSurname(), "Толстой");
    }

    @Test
    public void findByFirstnameSurnameAndMiddlenameMethodShouldReturnAuthor() {
        Author author1 = authorRepository.findByFirstnameAndSurnameAndMiddlename("Лев", "Толстой", "Николаевич");
        Assert.assertEquals(author1.getFirstname(), "Лев");
        Assert.assertEquals(author1.getSurname(), "Толстой");
        Assert.assertEquals(author1.getMiddlename(), "Николаевич");
    }

}
