package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface JpaRepositoryClient extends JpaRepository<Client, Integer> {

    /**
     * Returns the {@code Client} with specified ID
     *
     * @param id unique identifier
     * @return {@code Client} or {@code null} if found nothing
     */
    Client findById(int id);

    /**
     * Returns the {@code Client} with specified unique name
     *
     * @param nickname - unique {@code Client's} nickname
     * @return {@code Client} or {@code null} if found nothing
     */
    Client findByNickname(String nickname);

    /**
     * Returns the {@code Client} with specified email
     *
     * @param email - {@code Client's} email
     * @return {@code Client} or {@code null} if found nothing
     */
    Client findByEmail(String email);
}
