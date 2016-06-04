package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.TokenRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Token;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenRepository tokenRepository;

    @Override
    public List<Token> getAllTokensForClient(Client client) {
        return tokenRepository.findAllByClient(client);
    }

    @Override
    public List<Token> getAll() {
        return tokenRepository.findAll();
    }

    @Override
    public Token addToken(Client client, String tokenText) {
        Token token = new Token();
        token.setClient(client);
        token.setToken(tokenText);
        tokenRepository.save(token);
        return token;
    }

}
