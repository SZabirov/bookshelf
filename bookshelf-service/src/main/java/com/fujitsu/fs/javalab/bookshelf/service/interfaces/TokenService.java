package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.Token;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface TokenService {

    /**
     * Returns all the Tokens of the Client
     *
     * @param client
     * @return Token list or null if there is none
     */
    List<Token> getAllTokensForClient(Client client);

    /**
     * Returns all the presented Tokens
     * @return list of Token or null if there is none
     */
    List<Token> getAll();

    /**
     * Saves new Token. Returns created entity
     *
     * @param client
     * @param token
     * @return Token
     */
    Token addToken(Client client, String token);
}
