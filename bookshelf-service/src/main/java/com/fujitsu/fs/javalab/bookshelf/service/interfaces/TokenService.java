package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Token;
import com.fujitsu.fs.javalab.bookshelf.models.Client;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface TokenService {

    List<Token> getAllTokensForClient(Client client);

    List<Token> getAll();

    Token addToken(Client client, String token);
}
