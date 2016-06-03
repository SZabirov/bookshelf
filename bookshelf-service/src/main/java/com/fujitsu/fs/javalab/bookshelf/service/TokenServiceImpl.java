package com.fujitsu.fs.javalab.bookshelf.service;


import com.fujitsu.fs.javalab.bookshelf.dao.repository.TokenRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Token;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
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
    public List<Token> getAllTokensForUser(Users users) {
        return tokenRepository.findAllByUsers(users);
    }

    @Override
    public List<Token> getAll() {
        return tokenRepository.findAll();
    }

    @Override
    public Token addToken(Users users, String tokenText) {
        Token token = new Token();
        token.setUsers(users);
        token.setToken(tokenText);
        tokenRepository.save(token);
        return token;
    }

}
