package com.fujitsu.fs.javalab.bookshelf.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Айгуль on 04.05.2016.
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "pubhouse")
    private String pubhouse;

    @Basic
    @Column(name = "pub_year")
    private String pubYear;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "photo")
    private String photo;

    @Basic
    @Column(name = "verified")
    private Boolean verified;

    @ManyToOne(targetEntity = AuthorBookname.class)
    @JoinColumn(name = "author_bookname_id", referencedColumnName = "id")
    private AuthorBookname authorBookname;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private List<UsersHaving> usersHavings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPubhouse() {
        return pubhouse;
    }

    public void setPubhouse(String pubhouse) {
        this.pubhouse = pubhouse;
    }

    public String getPubYear() {
        return pubYear;
    }

    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public AuthorBookname getAuthorBookname() {
        return authorBookname;
    }

    public void setAuthorBookname(AuthorBookname authorBookname) {
        this.authorBookname = authorBookname;
    }

    public List<UsersHaving> getUsersHavings() {
        return usersHavings;
    }

    public void setUsersHavings(List<UsersHaving> usersHavings) {
        this.usersHavings = usersHavings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (pubhouse != null ? !pubhouse.equals(book.pubhouse) : book.pubhouse != null) return false;
        if (pubYear != null ? !pubYear.equals(book.pubYear) : book.pubYear != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (photo != null ? !photo.equals(book.photo) : book.photo != null) return false;
        if (verified != null ? !verified.equals(book.verified) : book.verified != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pubhouse='" + pubhouse + '\'' +
                ", pubYear='" + pubYear + '\'' +
                ", authorBookname=" + authorBookname +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pubhouse != null ? pubhouse.hashCode() : 0);
        result = 31 * result + (pubYear != null ? pubYear.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (verified != null ? verified.hashCode() : 0);
        return result;
    }

}
