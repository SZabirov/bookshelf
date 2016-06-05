package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientWish;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface ClientWishService {

    /**
     * Returns all the client's wishes
     *
     * @param client
     * @return Client list or null if there is none.
     */
    List<ClientWish> getAllClientWishesForClient(Client client);

    /**
     * Deletes ClientWish by Client and AuthorBookname
     *
     * @param client
     * @param authorBookname
     */
    void deleteClientWish(Client client, AuthorBookname authorBookname);

    /**
     * Returns all AuthorBooknames for the specified client
     * that he wishes
     *
     * @param client
     * @return list of AuthorBooknames or null if there is none.
     */
    List<AuthorBookname> getAllBooksThatClientWishes(Client client);  //AuthorBookname list, that Client wishes

    /**
     * Adds new ClientWish. Returns created object
     *
     * @param client
     * @param authorBookname
     * @return ClientWish
     */
    ClientWish addClientWish(Client client, AuthorBookname authorBookname);

    /**
     * Adds new Wishing if it's not presented yet.
     * Returns created entity or entity that already exists.
     * Creates Author and AuthorBookname if they
     * doesn't exit.
     *
     * @param authorName
     * @param authorSurname
     * @param authorMiddlename
     * @param bookname
     * @param client
     * @return Wishing
     */
    ClientWish addWishing(String authorName, String authorSurname, String authorMiddlename, String bookname, Client client);

    /**
     * Deletes Wish by id
     *
     * @param id
     */
    void deleteById(Integer id);

}
