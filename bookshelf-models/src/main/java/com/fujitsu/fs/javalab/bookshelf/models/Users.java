package com.fujitsu.fs.javalab.bookshelf.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Айгуль on 04.05.2016.
 */
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
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

    @OneToMany(mappedBy = "users")
    private List<Token> tokens;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<UsersHaving> usersHavings;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<UsersWish> usersWishes;

    @OneToMany(mappedBy = "receiver", fetch = FetchType.EAGER)
    private List<Messages> messages;

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

    public List<UsersHaving> getUsersHavings() {
        return usersHavings;
    }

    public void setUsersHavings(List<UsersHaving> usersHavings) {
        this.usersHavings = usersHavings;
    }

    public List<UsersWish> getUsersWishes() {
        return usersWishes;
    }

    public void setUsersWishs(List<UsersWish> usersWishes) {
        this.usersWishes = usersWishes;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (nickname != null ? !nickname.equals(users.nickname) : users.nickname != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (firstname != null ? !firstname.equals(users.firstname) : users.firstname != null) return false;
        if (surname != null ? !surname.equals(users.surname) : users.surname != null) return false;
        if (city != null ? !city.equals(users.city) : users.city != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (hashpassword != null ? !hashpassword.equals(users.hashpassword) : users.hashpassword != null) return false;
        if (avatar != null ? !avatar.equals(users.avatar) : users.avatar != null) return false;

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
        return "Users{" +
                "nickname='" + nickname + '\'' +
                ", city='" + city + '\'' +
                ", hashpassword='" + hashpassword + '\'' +
                '}';
    }
}
