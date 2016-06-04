package com.fujitsu.fs.javalab.bookshelf.service.interfaces;

import com.fujitsu.fs.javalab.bookshelf.models.Client;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface ClientService {

    void addNewClient(String nickname, String email, String firstname, String surname,
                     String city, String phone, String hashpassword, String avatar);

    void updateClient(int id, String new_nickname, String new_email, String new_firstname,
                    String new_surname, String new_city, String new_phone, String new_hashpassword,
                    String new_avatar);

    boolean ifCorrectClient(int id, String hashpassword);

    Client getClientById(int id);

    List<Client> getAll();

    Client getClientByNickname(String nickname);

    boolean ifNicknameExists(String nickname);

    boolean ifEmailExists(String email);
}
