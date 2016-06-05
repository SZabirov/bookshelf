package com.fujitsu.fs.javalab.bookshelf.dao.repository;


import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    /**
     * Returns all the Tokens from the table
     *
     * @return list of tokens or null if there is none
     */
    List<Token> findAll();

    /**
     * Returns all the Tokens
     * of the specified Client
     *
     * @return list of tokens or null if there is none
     */
    List<Token> findAllByClient(Client client);

}
