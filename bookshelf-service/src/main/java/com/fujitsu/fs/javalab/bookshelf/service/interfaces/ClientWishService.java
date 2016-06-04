package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientWish;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface ClientWishService {

    List<ClientWish> getAllClientWishesForClient(Client client);

    void deleteClientWish(Client client, AuthorBookname authorBookname);

    List<AuthorBookname> getAllBooksThatClientWishes(Client client);  //AuthorBookname list, that Client wishes

    ClientWish addClientWish(Client client, AuthorBookname authorBookname);

    ClientWish addWishing(String authorName, String authorSurname, String authorMiddlename, String bookname, Client client);

    void deleteById(Integer id);

}
