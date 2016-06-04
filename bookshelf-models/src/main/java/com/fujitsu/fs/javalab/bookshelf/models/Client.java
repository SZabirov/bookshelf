package com.fujitsu.fs.javalab.bookshelf.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Айгуль on 04.05.2016.
 */
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
    @SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "nickname")
    private String nickname;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "surname")
    private String surname;

    @Basic
    @Column(name = "city")
    private String city;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "hashpassword")
    private String hashpassword;

    @Basic
    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Token> tokens;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<ClientHaving> clientHavings;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<ClientWish> clientWishes;

    @OneToMany(mappedBy = "receiver", fetch = FetchType.EAGER)
    private List<Message> message;

    @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
    private List<Message> sentMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHashpassword() {
        return hashpassword;
    }

    public void setHashpassword(String hashpassword) {
        this.hashpassword = hashpassword;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<ClientHaving> getClientHavings() {
        return clientHavings;
    }

    public void setClientHavings(List<ClientHaving> clientHavings) {
        this.clientHavings = clientHavings;
    }

    public List<ClientWish> getClientWishes() {
        return clientWishes;
    }

    public void setClientWishs(List<ClientWish> clientWishes) {
        this.clientWishes = clientWishes;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Message> getSentMessage() {
        return sentMessage;
    }

    public void setSentMessage(List<Message> sentMessage) {
        this.sentMessage = sentMessage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (nickname != null ? !nickname.equals(client.nickname) : client.nickname != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (firstname != null ? !firstname.equals(client.firstname) : client.firstname != null) return false;
        if (surname != null ? !surname.equals(client.surname) : client.surname != null) return false;
        if (city != null ? !city.equals(client.city) : client.city != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        if (hashpassword != null ? !hashpassword.equals(client.hashpassword) : client.hashpassword != null) return false;
        if (avatar != null ? !avatar.equals(client.avatar) : client.avatar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (hashpassword != null ? hashpassword.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nickname='" + nickname + '\'' +
                ", city='" + city + '\'' +
                ", hashpassword='" + hashpassword + '\'' +
                '}';
    }
}
