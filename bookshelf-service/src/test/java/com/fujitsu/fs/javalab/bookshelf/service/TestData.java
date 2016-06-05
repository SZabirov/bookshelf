package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.*;
import com.fujitsu.fs.javalab.bookshelf.models.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

/**
 * Creating all the necessary class instances.
 * Creating of all mocks for repository classes.
 * Defining the output of certain method calls.
 *
 */
public class TestData {

    private Author author;
    private AuthorBookname authorBookname;
    private Book book;
    private Message message;
    private Client client;
    private Client client2;
    private Token token;
    private ClientHaving clientHaving;
    private ClientWish clientWish;

    private List<AuthorBookname> authorBooknames;
    private List<Author> authors;
    private List<Book> books;
    private List<Message> messageList;
    private List<ClientHaving> clientHavings;
    private List<ClientWish> clientWishes;
    private List<Token> tokens;
    private List<Client> clients;

    private JpaRepositoryAuthorBookname jpaRepositoryAuthorBookname;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private MessageRepository messageRepository;
    private TokenRepository tokenRepository;
    private ClientHavingRepository clientHavingRepository;
    private ClientWishRepository clientWishRepository;
    private JpaRepositoryClient jpaRepositoryClient;

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
        book.setId(1);
        book.setAuthorBookname(authorBookname);
        book.setPubhouse("АСТ");
        book.setVerified(true);

        client = new Client();
        client.setNickname("login");
        client.setPhone("123456789");
        client.setEmail("email@mail.ru");
        client.setCity("city");
        client.setHashpassword("12345");

        client2 = new Client();
        client2.setNickname("login2");
        client2.setEmail("email2@mail.ru");

        token = new Token();
        token.setClient(client);
        token.setToken("token");

        clientHaving = new ClientHaving();
        clientHaving.setClient(client);
        clientHaving.setBook(book);

        clientWish = new ClientWish();
        clientWish.setClient(client);
        clientWish.setAuthorBookname(authorBookname);

        message = new Message();
        message.setSender(client);
        message.setReceiver(client2);
        message.setHavingBook(book);
        message.setWishBook(book);

        authorBooknames = new ArrayList<>();
        authorBooknames.add(authorBookname);

        authors = new ArrayList<>();
        authors.add(author);

        books = new ArrayList<>();
        books.add(book);

        tokens = new ArrayList<>();
        tokens.add(token);

        clients = new ArrayList<>();
        clients.add(client);
        clients.add(client2);

        messageList = new ArrayList<>();
        messageList.add(message);

        clientHavings = new ArrayList<>();
        clientHavings.add(clientHaving);

        clientWishes = new ArrayList<>();
        clientWishes.add(clientWish);

        jpaRepositoryAuthorBookname = mock(JpaRepositoryAuthorBookname.class);
        when(jpaRepositoryAuthorBookname.findAll()).thenReturn(authorBooknames);
        when(jpaRepositoryAuthorBookname.findAllByAuthor(any(Author.class))).thenReturn(null);
        when(jpaRepositoryAuthorBookname.findAllByAuthor(author)).thenReturn(authorBooknames);
        when(jpaRepositoryAuthorBookname.findAllByBookname(anyString())).thenReturn(null);
        when(jpaRepositoryAuthorBookname.findAllByBookname(authorBookname.getBookname())).thenReturn(authorBooknames);
        when(jpaRepositoryAuthorBookname.findByAuthorAndBookname(any(Author.class), anyString())).thenReturn(null);
        when(jpaRepositoryAuthorBookname.findByAuthorAndBookname(author, authorBookname.getBookname())).thenReturn(authorBookname);
        when(jpaRepositoryAuthorBookname.save(any(AuthorBookname.class))).thenReturn(authorBookname);

        authorRepository = mock(AuthorRepository.class);
        when(authorRepository.findAll()).thenReturn(authors);
        when(authorRepository.findById(anyInt())).thenReturn(null);
        when(authorRepository.findById(author.getId())).thenReturn(author);
        when(authorRepository.findAllByFirstnameAndSurname(anyString(), anyString())).thenReturn(null);
        when(authorRepository.findAllByFirstnameAndSurname(author.getFirstname(), author.getSurname())).thenReturn(authors);
        when(authorRepository.findByFirstnameAndSurnameAndMiddlename(anyString(), anyString(), anyString())).thenReturn(null);
        when(authorRepository.findByFirstnameAndSurnameAndMiddlename(author.getFirstname(), author.getSurname(), author.getMiddlename())).thenReturn(author);
        when(authorRepository.save(any(Author.class))).thenReturn(null);
        when(authorRepository.save(author)).thenReturn(author);

        bookRepository = mock(BookRepository.class);
        when(bookRepository.findAll()).thenReturn(books);
        when(bookRepository.findById(anyInt())).thenReturn(null);
        when(bookRepository.findById(book.getId())).thenReturn(book);
        when(bookRepository.findAllByAuthorBookname(any(AuthorBookname.class))).thenReturn(null);
        when(bookRepository.findAllByAuthorBookname(authorBookname)).thenReturn(books);
        when(bookRepository.save(book)).thenReturn(book);

        messageRepository = mock(MessageRepository.class);
        when(messageRepository.findByReceiver(any(Client.class))).thenReturn(null);
        when(messageRepository.findByReceiver(client)).thenReturn(messageList);
        when(messageRepository.findBySender(any(Client.class))).thenReturn(null);
        when(messageRepository.findBySender(client2)).thenReturn(messageList);
        when(messageRepository.findById(anyInt())).thenReturn(null);
        when(messageRepository.findById(message.getId())).thenReturn(message);
        when(messageRepository.save(message)).thenReturn(message);

        tokenRepository = mock(TokenRepository.class);
        when(tokenRepository.findAll()).thenReturn(tokens);
        when(tokenRepository.findAllByClient(any(Client.class))).thenReturn(null);
        when(tokenRepository.findAllByClient(client)).thenReturn(tokens);
        when(tokenRepository.save(any(Token.class))).thenReturn(token);

        clientHavingRepository = mock(ClientHavingRepository.class);
        when(clientHavingRepository.findAll()).thenReturn(clientHavings);
        when(clientHavingRepository.findAllByClient(any(Client.class))).thenReturn(null);
        when(clientHavingRepository.findAllByClient(client)).thenReturn(clientHavings);
        when(clientHavingRepository.findAllByBook(any(Book.class))).thenReturn(null);
        when(clientHavingRepository.findAllByBook(book)).thenReturn(clientHavings);
        when(clientHavingRepository.findByClientAndBook(any(Client.class), any(Book.class))).thenReturn(null);
        when(clientHavingRepository.findByClientAndBook(client, book)).thenReturn(clientHaving);
        when(clientHavingRepository.save(any(ClientHaving.class))).thenReturn(clientHaving);

        clientWishRepository = mock(ClientWishRepository.class);
        when(clientWishRepository.findAll()).thenReturn(clientWishes);
        when(clientWishRepository.findAllByClient(any(Client.class))).thenReturn(null);
        when(clientWishRepository.findAllByClient(client)).thenReturn(clientWishes);
        when(clientWishRepository.findById(anyInt())).thenReturn(null);
        when(clientWishRepository.findById(clientWish.getId())).thenReturn(clientWish);
        when(clientWishRepository.findByClientAndAuthorBookname(any(Client.class), any(AuthorBookname.class))).thenReturn(null);
        when(clientWishRepository.findByClientAndAuthorBookname(client, authorBookname)).thenReturn(clientWish);
        when(clientWishRepository.save(any(ClientWish.class))).thenReturn(clientWish);

        jpaRepositoryClient = mock(JpaRepositoryClient.class);
        when(jpaRepositoryClient.findAll()).thenReturn(clients);
        when(jpaRepositoryClient.findById(anyInt())).thenReturn(null);
        when(jpaRepositoryClient.findById(client.getId())).thenReturn(client);
        when(jpaRepositoryClient.findByEmail(anyString())).thenReturn(null);
        when(jpaRepositoryClient.findByEmail(client.getEmail())).thenReturn(client);
        when(jpaRepositoryClient.findByNickname(anyString())).thenReturn(null);
        when(jpaRepositoryClient.findByNickname(client.getNickname())).thenReturn(client);
        when(jpaRepositoryClient.save(any(Client.class))).thenReturn(client);
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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient2() {
        return client2;
    }

    public void setClient2(Client client2) {
        this.client2 = client2;
    }

    public ClientHaving getClientHaving() {
        return clientHaving;
    }

    public void setClientHaving(ClientHaving clientHaving) {
        this.clientHaving = clientHaving;
    }

    public ClientWish getClientWish() {
        return clientWish;
    }

    public void setClientWish(ClientWish clientWish) {
        this.clientWish = clientWish;
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

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<ClientHaving> getClientHavings() {
        return clientHavings;
    }

    public void setClientHavings(List<ClientHaving> clientHavings) {
        this.clientHavings = clientHavings;
    }

    public List<ClientWish> getClientWishes() {
        return clientWishes;
    }

    public void setClientWishes(List<ClientWish> clientWishes) {
        this.clientWishes = clientWishes;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
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

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageRepository getMessageRepository() {
        return messageRepository;
    }

    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public TokenRepository getTokenRepository() {
        return tokenRepository;
    }

    public void setTokenRepository(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public ClientHavingRepository getClientHavingRepository() {
        return clientHavingRepository;
    }

    public void setClientHavingRepository(ClientHavingRepository clientHavingRepository) {
        this.clientHavingRepository = clientHavingRepository;
    }

    public ClientWishRepository getClientWishRepository() {
        return clientWishRepository;
    }

    public void setClientWishRepository(ClientWishRepository clientWishRepository) {
        this.clientWishRepository = clientWishRepository;
    }

    public JpaRepositoryClient getJpaRepositoryClient() {
        return jpaRepositoryClient;
    }

    public void setJpaRepositoryClient(JpaRepositoryClient jpaRepositoryClient) {
        this.jpaRepositoryClient = jpaRepositoryClient;
    }
}
