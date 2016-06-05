package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Book;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookRepositoryTest {

    private static BookRepository bookRepository;
    private static JpaRepositoryAuthorBookname authorBooknameRepository;

    @BeforeClass
    public static void prepareData() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("repository-config.xml");
        bookRepository = ctx.getBean(BookRepository.class);
        authorBooknameRepository = ctx.getBean(JpaRepositoryAuthorBookname.class);
    }

    @Test
    public void findAllMethodShouldReturnNotEmptyList() {
        Assert.assertNotNull(bookRepository.findAll());
    }

    @Test
    public void findByIdMethodShouldReturnBook() {
        Book book1 = bookRepository.findById(1);
        Assert.assertEquals(book1.getId(), 1);
    }

    @Test
    public void findAllByAuthorBookNameTest() {
        AuthorBookname authorBookname = authorBooknameRepository.findOne(1);
        Book b = bookRepository.findAllByAuthorBookname(authorBookname).get(0);
        Assert.assertEquals(b.getId(), 1);
        Assert.assertEquals(b.getDescription(), "Good book");
    }

}
