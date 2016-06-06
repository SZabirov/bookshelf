package com.fujitsu.fs.javalab.bookshelf.models;

import javax.persistence.*;

/**
 * Created by Айгуль on 04.05.2016.
 */
@Entity
@Table(name = "client_wish")
public class ClientWish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_wish_id_seq")
    @SequenceGenerator(name = "client_wish_id_seq", sequenceName = "client_wish_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = AuthorBookname.class)
    @JoinColumn(name = "author_bookname_id", referencedColumnName = "id")
    private AuthorBookname authorBookname;

    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

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

        ClientWish clientWish = (ClientWish) o;

        if (!authorBookname.equals(clientWish.authorBookname)) return false;
        if (!client.equals(clientWish.client)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = authorBookname.hashCode();
        result = 31 * result + client.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ClientWish{" +
                "authorBookname=" + authorBookname +
                ", client=" + client +
                '}';
    }
}
