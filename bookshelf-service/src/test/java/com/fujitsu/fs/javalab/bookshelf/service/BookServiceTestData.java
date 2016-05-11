package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.service.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceTestData {
    private Book book1;
    private Book book2;
    private List<Book> books;

    public BookServiceTestData() {
        book1 = new Book();
        book2 = new Book();
        book1.setId(1);
        book2.setId(2);
        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
    }

    public Book getBook1() {
        return book1;
    }

    public Book getBook2() {
        return book2;
    }

    public List<Book> getBooksList() {
        return books;
    }
}
