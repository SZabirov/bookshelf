package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.Token;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface TokenService {

    /**
     * Returns all the {@code Tokens} of the {@code Client}
     *
     * @param client {@code Client} to search {@code Tokens} of
     * @return {@code Token} List or {@code null} if there is none
     */
    List<Token> getAllTokensForClient(Client client);

    /**
     * Returns all the presented {@code Tokens}
     *
     * @return {@code List} of {@code Token} or {@code null} if there is none
     */
    List<Token> getAll();

    /**
     * Saves new {@code Token}. Returns created entity
     *
     * @param client client to add {@code Token} to
     * @param token  {@code Token} to add
     * @return {@code Token}
     */
    Token addToken(Client client, String token);
}
