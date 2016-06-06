package com.fujitsu.fs.javalab.bookshelf.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by Айгуль on 04.05.2016.
 */
@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    @SequenceGenerator(name = "author_id_seq", sequenceName = "author_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "surname")
    private String surname;

    @Basic
    @Column(name = "middlename")
    private String middlename;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<AuthorBookname> authorBooknames;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (firstname != null ? !firstname.equals(author.firstname) : author.firstname != null) return false;
        if (surname != null ? !surname.equals(author.surname) : author.surname != null) return false;
        if (middlename != null ? !middlename.equals(author.middlename) : author.middlename != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        return result;
    }

    public List<AuthorBookname> getAuthorBooknames() {
        return authorBooknames;
    }

    public void setAuthorBooknames(List<AuthorBookname> authorBooknames) {
        this.authorBooknames = authorBooknames;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", middlename='" + middlename + '\'' +
                '}';
    }
}
