package com.fujitsu.fs.javalab.bookshelf.service.models;

import javax.persistence.*;

/**
 * Created by Айгуль on 04.05.2016.
 */
@Entity
@Table(name = "users_wish")
public class UsersWish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_wish_id_seq")
    @SequenceGenerator(name = "users_wish_id_seq", sequenceName = "users_wish_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = AuthorBookname.class)
    @JoinColumn(name = "author_bookname_id", referencedColumnName = "id")
    private AuthorBookname authorBookname;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private Users users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AuthorBookname getAuthorBookname() {
        return authorBookname;
    }

    public void setAuthorBookname(AuthorBookname authorBookname) {
        this.authorBookname = authorBookname;
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

        UsersWish usersWish = (UsersWish) o;

        if (id != usersWish.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
