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
     * Returns all the {@code ClientWishes}
     *
     * @return {@code List} of {@code ClientWishes} or {@code null} if none was found
     */
    List<ClientWish> findAll();

    /**
     * Returns {@code ClientWish} with specified ID
     *
     * @param id unique identifier of the {@code ClientWish}
     * @return {@code ClientWish} or {@code null} if none was found
     */
    ClientWish findById(int id);

    /**
     * Returns {@code ClientWish} with specified client
     * and {@code AuthorBookname}
     *
     * @param client         {@code Client} to search
     * @param authorBookname {@code AuthorBookname} to search
     * @return {@code ClientWish} or {@code null} if couldn't find any
     */
    ClientWish findByClientAndAuthorBookname(Client client, AuthorBookname authorBookname);

    /**
     * Returns all the {@code ClientWishes}
     * of the specified Client
     *
     * @param client {@code Client} to search
     * @return {@code List} of {@code ClientWish} or {@code null} if none was found
     */
    List<ClientWish> findAllByClient(Client client);
}
