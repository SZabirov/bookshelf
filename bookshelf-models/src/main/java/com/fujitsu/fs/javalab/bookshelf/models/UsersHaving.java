package com.fujitsu.fs.javalab.bookshelf.models;

import javax.persistence.*;

/**
 * Created by Айгуль on 04.05.2016.
 */
@Entity
@Table(name = "users_having")
public class UsersHaving {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_having_id_seq")
    @SequenceGenerator(name = "users_having_id_seq", sequenceName = "users_having_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private Users users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersHaving that = (UsersHaving) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "UsersHaving{" +
                "users=" + users +
                ", book=" + book +
                '}';
    }
}
