package com.fujitsu.fs.javalab.bookshelf.models;

import javax.persistence.*;

/**
 * Created by Pc on 01.06.2016.
 */

@Entity
@Table(name="Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_seq")
    @SequenceGenerator(name = "message_id_seq", sequenceName = "message_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Client sender;

    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private Client receiver;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "having_book_id", referencedColumnName = "id")
    private Book havingBook;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "wish_book_id", referencedColumnName = "id")
    private Book wishBook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getReceiver() {
        return receiver;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }

    public Book getHavingBook() {
        return havingBook;
    }

    public void setHavingBook(Book havingBook) {
        this.havingBook = havingBook;
    }

    public Book getWishBook() {
        return wishBook;
    }

    public void setWishBook(Book wishBook) {
        this.wishBook = wishBook;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender.getNickname() +
                ", receiver=" + receiver.getNickname() +
                ", havingBook=" + havingBook.getAuthorBookname().getBookname() + " "
                + havingBook.getAuthorBookname().getAuthor().getSurname() +
                ", wishBook=" + wishBook.getAuthorBookname().getBookname() +
                '}';
    }
}
