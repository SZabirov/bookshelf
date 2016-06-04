package com.fujitsu.fs.javalab.bookshelf.dao.repository;


import com.fujitsu.fs.javalab.bookshelf.models.Token;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    List<Token> findAll();

    List<Token> findAllByClient(Client client);

}
