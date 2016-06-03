package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.TokenRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Token;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Created by aygulmardanova on 03.06.16.
 */
public class TokenServiceImplTest {

    private static TestData testData;
    private static Users users;
    private static Token token;
    private static List<Token> tokens;
    private static TokenRepository tokenRepository;
    private static TokenServiceImpl tokenService;

    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();
        users = testData.getUsers();
        token = testData.getToken();
        tokens = testData.getTokens();
        tokenRepository = testData.getTokenRepository();
        tokenService = new TokenServiceImpl();
        tokenService.tokenRepository = tokenRepository;
    }

    @Test
    public void getAllShouldReturnCorrectListOfTokens() {
        Assert.assertEquals(tokens, tokenService.getAll());
    }

    @Test
    public void getAllTokensForUserShouldReturnCorrectListIfUsersExists() {
        Assert.assertEquals(tokens, tokenService.getAllTokensForUser(users));
    }

    @Test
    public void getAllTokensForUserShouldReturnNullIfUsersDoesNotExist() {
        Assert.assertNull(tokenService.getAllTokensForUser(new Users()));
    }

    @Test
    public void addTokenShouldSaveCorrectUserToken() {
        Assert.assertEquals(token.getUsers(), tokenService.addToken(users, "token").getUsers());
    }

    @Test
    public void addTokenShouldSaveCorrectTokenTextIntoToken() {
        Assert.assertEquals(token.getToken(), tokenService.addToken(users, "token").getToken());
    }

    @Test
    public void addTokenShouldCallSaveMethodFromRepository() {
        tokenService.addToken(token.getUsers(), token.getToken());
        verify(tokenRepository, atLeastOnce()).save(any(Token.class));
    }
}
