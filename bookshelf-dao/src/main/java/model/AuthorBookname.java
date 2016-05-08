package model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Айгуль on 04.05.2016.
 */
@Entity
@Table(name = "author_bookname")
public class AuthorBookname {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_bookname_id_seq")
    @SequenceGenerator(name = "author_bookname_id_seq", sequenceName = "author_bookname_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "bookname")
    private String bookname;

    @Basic
    @Column(name = "verified")
    private Boolean verified;

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @OneToMany(mappedBy = "authorBookname")
    private Collection<Book> books;

    @OneToMany(mappedBy = "authorBookname")
    private Collection<UsersWish> usersWishes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorBookname that = (AuthorBookname) o;

        if (id != that.id) return false;
        if (bookname != null ? !bookname.equals(that.bookname) : that.bookname != null) return false;
        if (verified != null ? !verified.equals(that.verified) : that.verified != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookname != null ? bookname.hashCode() : 0);
        result = 31 * result + (verified != null ? verified.hashCode() : 0);
        return result;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public Collection<UsersWish> getUsersWishes() {
        return usersWishes;
    }

    public void setUsersWishes(Collection<UsersWish> usersWishes) {
        this.usersWishes = usersWishes;
    }
}
