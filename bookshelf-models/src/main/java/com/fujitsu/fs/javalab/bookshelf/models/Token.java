package com.fujitsu.fs.javalab.bookshelf.models;

import javax.persistence.*;

/**
 * Created by Айгуль on 04.05.2016.
 */
@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_id_seq")
    @SequenceGenerator(name = "token_id_seq", sequenceName = "token_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "token")
    private String token;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private Users users;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

        Token token1 = (Token) o;

        if (id != token1.id) return false;
        if (token != null ? !token.equals(token1.token) : token1.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", users=" + users +
                '}';
    }
}
