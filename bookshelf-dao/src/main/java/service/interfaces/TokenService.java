package service.interfaces;

import model.Token;
import model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Service
public interface TokenService {

    List<Token> getAllTokensForUser(Users users);

    Token getById(int id);

    List<Token> getAll();

}
