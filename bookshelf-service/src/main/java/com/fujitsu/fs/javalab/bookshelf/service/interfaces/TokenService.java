package com.fujitsu.fs.javalab.bookshelf.service.interfaces;


import com.fujitsu.fs.javalab.bookshelf.models.Token;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
//@Service
public interface TokenService {

    List<Token> getAllTokensForUser(Users users);

    Token getById(int id);

    List<Token> getAll();

}
