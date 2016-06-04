package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.TokenRepository;
import com.fujitsu.fs.javalab.bookshelf.models.Token;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
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
    private static Client client;
    private static Token token;
    private static List<Token> tokens;
    private static TokenRepository tokenRepository;
    private static TokenServiceImpl tokenService;

    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();
        client = testData.getClient();
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
    public void getAllTokensForClientShouldReturnCorrectListIfClientExists() {
        Assert.assertEquals(tokens, tokenService.getAllTokensForClient(client));
    }

    @Test
    public void getAllTokensForClientShouldReturnNullIfClientDoesNotExist() {
        Assert.assertNull(tokenService.getAllTokensForClient(new Client()));
    }

    @Test
    public void addTokenShouldSaveCorrectClientToken() {
        Assert.assertEquals(token.getClient(), tokenService.addToken(client, "token").getClient());
    }

    @Test
    public void addTokenShouldSaveCorrectTokenTextIntoToken() {
        Assert.assertEquals(token.getToken(), tokenService.addToken(client, "token").getToken());
    }

    @Test
    public void addTokenShouldCallSaveMethodFromRepository() {
        tokenService.addToken(token.getClient(), token.getToken());
        verify(tokenRepository, atLeastOnce()).save(any(Token.class));
    }
}
