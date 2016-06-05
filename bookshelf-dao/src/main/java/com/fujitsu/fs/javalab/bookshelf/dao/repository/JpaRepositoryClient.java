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
     * Returns the client with specified id
     *
     * @param id unique identifier
     * @return Client or null if found nothing
     */
    Client findById(int id);

    /**
     * Returns the client with specified unique name
     *
     * @param nickname
     * @return Client or null if found nothing
     */
    Client findByNickname(String nickname);

    /**
     * Returns the client with specified email
     *
     * @param email
     * @return Client or null if found nothing
     */
    Client findByEmail(String email);
}
