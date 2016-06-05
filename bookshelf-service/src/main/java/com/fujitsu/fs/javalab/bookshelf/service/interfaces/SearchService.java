package com.fujitsu.fs.javalab.bookshelf.service.interfaces;

import com.fujitsu.fs.javalab.bookshelf.models.Book;

import java.util.List;

public interface SearchService {

    /**
     * Returns Books that match to the response.
     * Returns null if there is no such Author,
     * if there is no AuthorBooknames of the Author.
     *
     * @param authorName
     * @param authorSurname
     * @param bookname
     * @return Book list or null
     */
    public List<Book> getSearchResult(String authorName, String authorSurname, String bookname);
}
