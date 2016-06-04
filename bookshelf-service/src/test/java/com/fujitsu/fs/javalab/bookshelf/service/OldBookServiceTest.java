package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.BookRepository;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.BookService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Created by aygulmardanova on 03.06.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestServiceContext.class})
public class OldBookServiceTest {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    BookServiceTestData bookServiceTestData;

    @Ignore
    @Before
    public void setUp() {
        bookServiceTestData = new BookServiceTestData();
        Mockito.reset(bookRepository);
        Mockito.doReturn(bookServiceTestData.getBooksList()).when(bookRepository).findAll();
    }

    @Ignore
    @Test
    public void testGetAll() {
        bookService.getAll();
        verify(bookRepository).findAll();
    }

    @Ignore
    @Test
    public void testGetAllOnCorrectData() {
        bookService.getAll();
        assertEquals(bookServiceTestData.getBooksList(), bookRepository.findAll());
    }

}
