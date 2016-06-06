package com.fujitsu.fs.javalab.bookshelf.service.interfaces;

import com.fujitsu.fs.javalab.bookshelf.models.Book;

import java.util.List;

public interface SearchService {

    /**
     * Returns {@code Books} that match to the response.
     * Returns {@code null} if there is no such {@code Author},
     * if there is no {@code AuthorBooknames} of the {@code Author}.
     *
     * @param authorName    name of author of the book
     * @param authorSurname surname of author of the book
     * @param bookname      name of the book
     * @return {@code List} of {@code Book} or {@code null}
     */
    public List<Book> getSearchResult(String authorName, String authorSurname, String bookname);
}
