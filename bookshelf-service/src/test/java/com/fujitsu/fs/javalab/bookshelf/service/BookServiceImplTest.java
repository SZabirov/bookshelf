package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.service.interfaces.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.fujitsu.fs.javalab.bookshelf.service.dao.repository.BookRepository;

import static org.mockito.Mockito.verify;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestServiceContext.class})
public class BookServiceImplTest {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @Before
    public void setUp() {
        Mockito.doReturn(null).when(bookRepository).findAll();
    }

    @Test
    public void testGetAll() {
        bookService.getAll();
        verify(bookRepository).findAll();
    }
}
