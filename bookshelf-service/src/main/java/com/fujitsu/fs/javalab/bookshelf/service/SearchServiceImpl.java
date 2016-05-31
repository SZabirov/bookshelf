package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorBooknameService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.BookService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    AuthorBooknameService authorBooknameService;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @Override
    public List<Book> getSearchResult(String authorName, String authorSurname, String bookname) {
        Author author = authorService.getAuthorByFirstnameAndSurname(authorName, authorSurname);
        List<AuthorBookname> authorBooknameList = authorBooknameService.getAllByAuthorAndBookname(author, bookname);
        List <Book> bookList = new ArrayList<>();
        for (AuthorBookname authorBookname : authorBooknameList) {
            bookList.addAll(bookService.getBooksByAuthorBookname(authorBookname));
        }
        return bookList;
    }
}
