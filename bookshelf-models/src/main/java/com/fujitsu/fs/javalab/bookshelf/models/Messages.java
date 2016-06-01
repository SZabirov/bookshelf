package com.fujitsu.fs.javalab.bookshelf.models;

import javax.persistence.*;

/**
 * Created by Pc on 01.06.2016.
 */

@Entity
@Table(name="Messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messages_id_seq")
    @SequenceGenerator(name = "messages_id_seq", sequenceName = "messages_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Users sender;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private Users receiver;

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

    public Users getSender() {
        return sender;
    }

    public void setSender(Users sender) {
        this.sender = sender;
    }

    public Users getReceiver() {
        return receiver;
    }

    public void setReceiver(Users receiver) {
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
        return "Messages{" +
                "sender=" + sender.getNickname() +
                ", receiver=" + receiver.getNickname() +
                ", havingBook=" + havingBook.getAuthorBookname().getBookname() + " "
                + havingBook.getAuthorBookname().getAuthor().getSurname() +
                ", wishBook=" + wishBook.getAuthorBookname().getBookname() +
                '}';
    }
}
