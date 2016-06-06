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
     * Returns all the {@code Client's} {@code Wishes}
     *
     * @param client {@code Client} to get {@code Wishes} of
     * @return {@code List} of {@code Clients} or {@code null} if there is none.
     */
    List<ClientWish> getAllClientWishesForClient(Client client);

    /**
     * Deletes {@code Wishes} by {@code Client} and {@code AuthorBookname}
     *
     * @param client         {@code Client}
     * @param authorBookname {@code AuthorBookname} to delete
     */
    void deleteClientWish(Client client, AuthorBookname authorBookname);

    /**
     * Returns all the {@code AuthorBooknames} for the specified {@code Client}
     * that he wishes
     *
     * @param client {@code Client}
     * @return {@code List} of {@code AuthorBooknames} or {@code null} if there is none.
     */
    List<AuthorBookname> getAllBooksThatClientWishes(Client client);  //AuthorBookname list, that Client wishes

    /**
     * Adds new {@code Wish}. Returns created object
     *
     * @param client         {@code Client}
     * @param authorBookname {@code AuthorBookname} to delete
     * @return ClientWish
     */
    ClientWish addClientWish(Client client, AuthorBookname authorBookname);

    /**
     * Adds new Wishing if it's not presented yet.
     * Returns created entity or entity that already exists.
     * Creates Author and AuthorBookname if they
     * doesn't exit.
     *
     * @param authorName       name of {@code Author} to delete
     * @param authorSurname    surname of {@code Author} to delete
     * @param authorMiddlename middlename of {@code Author} to delete
     * @param bookname         name of {@code Book} to delete
     * @param client           {@code Client} to delete {@code Book} of
     * @return Wishing
     */
    ClientWish addWishing(String authorName, String authorSurname, String authorMiddlename, String bookname, Client client);

    /**
     * Deletes {@code Wish} by ID
     *
     * @param id ID of the {@code Client} to delete
     */
    void deleteById(Integer id);

}
