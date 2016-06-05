package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientWish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface ClientWishRepository extends JpaRepository<ClientWish, Integer> {

    /**
     * Returns all the ClientWishes
     *
     * @return list of ClientWishes or null if none was found
     */
    List<ClientWish> findAll();

    /**
     * Returns ClientWish with specified id
     *
     * @param id unique identifier of ClientWish
     * @return ClientWish or null if none was found
     */
    ClientWish findById(int id);

    /**
     * Returns ClientWish with specified client
     * and AuthorBookname
     *
     * @param client
     * @param authorBookname
     * @return ClientWish or null if couldn't find
     */
    ClientWish findByClientAndAuthorBookname(Client client, AuthorBookname authorBookname);

    /**
     * Returns all the ClientWishes
     * of the specified Client
     *
     * @param client
     * @return list of ClientWishes or null if none was found
     */
    List<ClientWish> findAllByClient(Client client);
}
