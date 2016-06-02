package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.AuthorRepository;
import com.fujitsu.fs.javalab.bookshelf.dao.repository.JpaRepositoryAuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.*;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.AuthorBooknameService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by aygulmardanova on 02.06.16.
 */
public class TestData {

    private Author author;

    private AuthorBookname authorBookname;

    private Book book;

    private Messages messages;

    private Token token;

    private Users users;

    private Users users2;

    private UsersHaving usersHaving;

    private UsersWish usersWish;

    private List<AuthorBookname> authorBooknames;

    private List<Author> authors;

    private List<Book> books;

    private List<Messages> messagesList;

    private List<UsersHaving> usersHavings;

    private List<UsersWish> usersWishes;

    private JpaRepositoryAuthorBookname jpaRepositoryAuthorBookname;

    private AuthorRepository authorRepository;

    public TestData() {
        author = new Author();
        author.setFirstname("Лев");
        author.setMiddlename("Николаевич");
        author.setSurname("Толстой");

        authorBookname = new AuthorBookname();
        authorBookname.setAuthor(author);
        authorBookname.setBookname("Война и Мир");
        authorBookname.setVerified(true);

        book = new Book();
        book.setAuthorBookname(authorBookname);
        book.setPubhouse("АСТ");
        book.setVerified(true);

        users = new Users();
        users.setNickname("login");
        users.setPhone("123456789");
        users.setEmail("email@mail.ru");
        users.setCity("city");

        users2 = new Users();
        users2.setNickname("login2");
        users2.setEmail("email2@mail.ru");

        usersHaving = new UsersHaving();
        usersHaving.setUsers(users);
        usersHaving.setBook(book);

        usersWish = new UsersWish();
        usersWish.setUsers(users);
        usersWish.setAuthorBookname(authorBookname);

        messages = new Messages();
        messages.setSender(users);
        messages.setReceiver(users2);
        messages.setHavingBook(book);
        messages.setWishBook(book);

        authorBooknames = new ArrayList<>();
        authorBooknames.add(authorBookname);
        authors = new ArrayList<>();
        authors.add(author);
        books = new ArrayList<>();
        books.add(book);
        messagesList = new ArrayList<>();
        messagesList.add(messages);

        usersHavings = new ArrayList<>();
        usersHavings.add(usersHaving);

        usersWishes = new ArrayList<>();
        usersWishes.add(usersWish);

        jpaRepositoryAuthorBookname = mock(JpaRepositoryAuthorBookname.class);
        when(jpaRepositoryAuthorBookname.findAll()).thenReturn(authorBooknames);
        when(jpaRepositoryAuthorBookname.findOneById(anyInt())).thenReturn(null);
        when(jpaRepositoryAuthorBookname.findOneById(authorBookname.getId())).thenReturn(authorBookname);
        when(jpaRepositoryAuthorBookname.findAllByAuthor(any(Author.class))).thenReturn(null);
        when(jpaRepositoryAuthorBookname.findAllByAuthor(author)).thenReturn(authorBooknames);
        when(jpaRepositoryAuthorBookname.findAllByBookname(anyString())).thenReturn(null);
        when(jpaRepositoryAuthorBookname.findAllByBookname(authorBookname.getBookname())).thenReturn(authorBooknames);
        when(jpaRepositoryAuthorBookname.findOneByAuthorAndBookname(any(Author.class), anyString())).thenReturn(null);
        when(jpaRepositoryAuthorBookname.findOneByAuthorAndBookname(author, authorBookname.getBookname())).thenReturn(authorBookname);
        when(jpaRepositoryAuthorBookname.findAllByAuthorAndBookname(any(Author.class), anyString())).thenReturn(null);
        when(jpaRepositoryAuthorBookname.findAllByAuthorAndBookname(author, authorBookname.getBookname())).thenReturn(authorBooknames);
        when(jpaRepositoryAuthorBookname.save(any(AuthorBookname.class))).thenReturn(authorBookname);

        authorRepository = mock(AuthorRepository.class);
        when(authorRepository.findAll()).thenReturn(authors);
        when(authorRepository.findOneById(anyInt())).thenReturn(null);
        when(authorRepository.findOneById(author.getId())).thenReturn(author);
        when(authorRepository.findByFirstnameAndSurname(anyString(), anyString())).thenReturn(null);
        when(authorRepository.findByFirstnameAndSurname(author.getFirstname(), author.getSurname())).thenReturn(author);
        when(authorRepository.findByFirstnameAndSurnameAndMiddlename(anyString(), anyString(), anyString())).thenReturn(null);
        when(authorRepository.findByFirstnameAndSurnameAndMiddlename(author.getFirstname(), author.getSurname(), author.getMiddlename())).thenReturn(author);
        when(authorRepository.save(any(Author.class))).thenReturn(null);
        when(authorRepository.save(author)).thenReturn(author);
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public AuthorBookname getAuthorBookname() {
        return authorBookname;
    }

    public void setAuthorBookname(AuthorBookname authorBookname) {
        this.authorBookname = authorBookname;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers2() {
        return users2;
    }

    public void setUsers2(Users users2) {
        this.users2 = users2;
    }

    public UsersHaving getUsersHaving() {
        return usersHaving;
    }

    public void setUsersHaving(UsersHaving usersHaving) {
        this.usersHaving = usersHaving;
    }

    public UsersWish getUsersWish() {
        return usersWish;
    }

    public void setUsersWish(UsersWish usersWish) {
        this.usersWish = usersWish;
    }

    public List<AuthorBookname> getAuthorBooknames() {
        return authorBooknames;
    }

    public void setAuthorBooknames(List<AuthorBookname> authorBooknames) {
        this.authorBooknames = authorBooknames;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Messages> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(List<Messages> messagesList) {
        this.messagesList = messagesList;
    }

    public List<UsersHaving> getUsersHavings() {
        return usersHavings;
    }

    public void setUsersHavings(List<UsersHaving> usersHavings) {
        this.usersHavings = usersHavings;
    }

    public List<UsersWish> getUsersWishes() {
        return usersWishes;
    }

    public void setUsersWishes(List<UsersWish> usersWishes) {
        this.usersWishes = usersWishes;
    }

    public JpaRepositoryAuthorBookname getJpaRepositoryAuthorBookname() {
        return jpaRepositoryAuthorBookname;
    }

    public void setJpaRepositoryAuthorBookname(JpaRepositoryAuthorBookname jpaRepositoryAuthorBookname) {
        this.jpaRepositoryAuthorBookname = jpaRepositoryAuthorBookname;
    }

    public AuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
