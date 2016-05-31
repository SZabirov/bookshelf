package com.fujitsu.fs.javalab.bookshelf.service.interfaces;

import com.fujitsu.fs.javalab.bookshelf.models.Book;

import java.util.List;

public interface SearchService {
    public List<Book> getSearchResult (String authorName, String authorSurname, String bookname);
}
