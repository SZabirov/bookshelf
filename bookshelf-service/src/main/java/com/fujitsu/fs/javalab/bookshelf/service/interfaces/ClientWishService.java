package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientWish;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface ClientWishService {

    ClientWish addClientWish(Client client, AuthorBookname authorBookname);

    ClientWish addWishing(String authorName, String authorSurname, String authorMiddlename, String bookname, Client client);

    void deleteById(Integer id);

}
