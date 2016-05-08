package service;

import model.Token;
import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TokenRepository;
import service.interfaces.TokenService;

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
    public Token getById(int id) {
        return tokenRepository.findOneById(id);
    }

    @Override
    public List<Token> getAll() {
        return tokenRepository.findAll();
    }
}
