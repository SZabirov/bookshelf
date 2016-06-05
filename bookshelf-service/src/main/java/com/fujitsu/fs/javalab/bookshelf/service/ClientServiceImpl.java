package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.JpaRepositoryClient;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    JpaRepositoryClient jpaRepositoryClient;

    @Override
    public void addNewClient(String nickname, String email, String firstname, String surname,
                            String city, String phone, String hashpassword, String avatar) {
        Client client = new Client();
        client.setNickname(nickname);
        client.setEmail(email);
        client.setFirstname(firstname);
        client.setSurname(surname);
        client.setCity(city);
        client.setPhone(phone);
        client.setHashpassword(hashpassword);
        client.setAvatar(avatar);
        jpaRepositoryClient.save(client);
    }

    @Override
    public void updateClient(int id, String new_nickname, String new_email, String new_firstname,
                           String new_surname, String new_city, String new_phone,
                           String new_hashpassword, String new_avatar) {
        Client client = jpaRepositoryClient.findById(id);
        if (new_nickname != null && !new_nickname.equals("")) {
            client.setNickname(new_nickname);
        }
        if (new_email != null && !new_email.equals("")) {
            client.setEmail(new_email);
        }
        if (new_firstname != null && !new_firstname.equals("")) {
            client.setFirstname(new_firstname);
        }
        if (new_surname != null && !new_surname.equals("")) {
            client.setSurname(new_surname);
        }
        if (new_city != null && !new_city.equals("")) {
            client.setCity(new_city);
        }
        if (new_phone != null && !new_phone.equals("")) {
            client.setPhone(new_phone);
        }
        if (new_hashpassword != null && !new_hashpassword.equals("")) {
            client.setHashpassword(new_hashpassword);
        }
        if (new_avatar != null && !new_avatar.equals("")) {
            client.setAvatar(new_avatar);
        }
        jpaRepositoryClient.save(client);
    }

    @Override
    public boolean ifCorrectClient(int id, String hashpassword) {
        Client client = jpaRepositoryClient.findById(id);
        return client != null && client.getHashpassword().equals(hashpassword);
    }

    @Override
    public Client getClientById(int id) {
        return jpaRepositoryClient.findById(id);
    }

    @Override
    public List<Client> getAll() {
        return jpaRepositoryClient.findAll();
    }

    @Override
    public Client getClientByNickname(String nickname) {
        return jpaRepositoryClient.findByNickname(nickname);
    }

    @Override
    public boolean ifNicknameExists(String nickname) {
        Client client = jpaRepositoryClient.findByNickname(nickname);
        return client != null;
    }

    @Override
    public boolean ifEmailExists(String email) {
        Client client = jpaRepositoryClient.findByEmail(email);
        return client != null;
    }

}
