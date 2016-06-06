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

    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;


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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token1 = (Token) o;

        if (!client.equals(token1.client)) return false;
        if (token != null ? !token.equals(token1.token) : token1.token != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + client.hashCode();
        result = 31 * result + token.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", client=" + client +
                '}';
    }
}
