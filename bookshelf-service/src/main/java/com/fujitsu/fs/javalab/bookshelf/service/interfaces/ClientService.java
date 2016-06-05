package com.fujitsu.fs.javalab.bookshelf.service.interfaces;

import com.fujitsu.fs.javalab.bookshelf.models.Client;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface ClientService {

    /**
     * Adds new client
     *
     * @param nickname
     * @param email
     * @param firstname
     * @param surname
     * @param city
     * @param phone
     * @param hashpassword
     * @param avatar
     */
    void addNewClient(String nickname, String email, String firstname, String surname,
                      String city, String phone, String hashpassword, String avatar);

    /**
     * Updates client by finding him by id.
     * All the fields for update should be not empty
     * and not equals to previous parameters, otherwise
     * fields won't be updated.
     *
     * @param id
     * @param new_nickname
     * @param new_email
     * @param new_firstname
     * @param new_surname
     * @param new_city
     * @param new_phone
     * @param new_hashpassword
     * @param new_avatar
     */
    void updateClient(int id, String new_nickname, String new_email, String new_firstname,
                      String new_surname, String new_city, String new_phone, String new_hashpassword,
                      String new_avatar);

    /**
     * Checks whether the password of the client
     * with specified id is correct.
     *
     * @param id
     * @param hashpassword
     * @return true if password is correct, false in other case
     */
    boolean ifCorrectClient(int id, String hashpassword);

    /**
     * Returns client by id
     *
     * @param id
     * @return Client or null if the id doesn't exist
     */
    Client getClientById(int id);

    /**
     * Returns all the Clients
     *
     * @return list of Clients or null if there is none
     */
    List<Client> getAll();

    /**
     * Returns Client with specified nickname
     *
     * @param nickname
     * @return Client or null if the nickname doesn't match to any
     */
    Client getClientByNickname(String nickname);

    /**
     * Checks whether there are Clients with the nickname
     *
     * @param nickname
     * @return true if the Client exists, false in other case
     */
    boolean ifNicknameExists(String nickname);

    /**
     * Checks whether there are Clients with the email
     *
     * @param email
     * @return true if the Client exists, false in other case
     */
    boolean ifEmailExists(String email);
}
