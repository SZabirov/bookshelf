package com.fujitsu.fs.javalab.bookshelf.service.interfaces;

import com.fujitsu.fs.javalab.bookshelf.models.Client;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface ClientService {

    /**
     * Adds new {@code Client}
     *
     * @param nickname     {@code Client's} nickname
     * @param email        {@code Client's} email
     * @param firstname    {@code Client's} firstname
     * @param surname      {@code Client's} surname
     * @param city         {@code Client's} city
     * @param phone        {@code Client's} phone
     * @param hashpassword {@code Client's} hashpassword
     * @param avatar       {@code Client's} avatar
     */
    void addNewClient(String nickname, String email, String firstname, String surname,
                      String city, String phone, String hashpassword, String avatar);

    /**
     * Updates {@code Client} by finding him by id.
     * All the fields for update should be not empty
     * and not equals to previous parameters, otherwise
     * fields won't be updated.
     *
     * @param id               ID of the {@code Client} to update
     * @param new_nickname     new {@code Client's} nickname
     * @param new_email        new {@code Client's} email
     * @param new_firstname    new {@code Client's} firstname
     * @param new_surname      new {@code Client's} surname
     * @param new_city         new {@code Client's} city
     * @param new_phone        new {@code Client's} phone
     * @param new_hashpassword new {@code Client's} hashpassword
     * @param new_avatar       new {@code Client's} avatar
     */
    void updateClient(int id, String new_nickname, String new_email, String new_firstname,
                      String new_surname, String new_city, String new_phone, String new_hashpassword,
                      String new_avatar);

    /**
     * Checks whether the password of the {@code Client}
     * with specified ID is correct.
     *
     * @param id           {@code Client's} ID
     * @param hashpassword {@code Client's} password
     * @return {@code true} if the password is correct, {@code false} in other case
     */
    boolean ifCorrectClient(int id, String hashpassword);

    /**
     * Returns {@code Client} by ID
     *
     * @param id unique identifier
     * @return {@code Client} or {@code null} if the ID doesn't exist
     */
    Client getClientById(int id);

    /**
     * Returns all the {@code Clients}
     *
     * @return {@code List} of {@code Clients} or {@code null} if there is none
     */
    List<Client> getAll();

    /**
     * Returns {@code Client} with specified nickname
     *
     * @param nickname unique {@code Client's} nickname
     * @return {@code Client} or {@code null} if the nickname doesn't match to any
     */
    Client getClientByNickname(String nickname);

    /**
     * Checks whether there are {@code Clients} with the nickname
     *
     * @param nickname unique {@code Client's} nickname
     * @return {@code true} if the Client exists, {@code false} in other case
     */
    boolean ifNicknameExists(String nickname);

    /**
     * Checks whether there are {@code Clients} with the email
     *
     * @param email {@code Client's}  email
     * @return {@code true} if the {@code Client} exists, {@code false} in other case
     */
    boolean ifEmailExists(String email);
}
