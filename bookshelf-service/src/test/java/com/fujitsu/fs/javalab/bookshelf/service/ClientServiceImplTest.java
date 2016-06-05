package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.JpaRepositoryClient;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by aygulmardanova on 05.06.16.
 */
public class ClientServiceImplTest {

    private static TestData testData;
    private static Client client;
    private static List<Client> clients;

    private static ClientServiceImpl clientService;
    private static JpaRepositoryClient jpaRepositoryClient;

    @BeforeClass
    public static void beforeClass() {
        testData = new TestData();
        client = testData.getClient();
        clients = testData.getClients();

        jpaRepositoryClient = testData.getJpaRepositoryClient();
        clientService = new ClientServiceImpl();
        clientService.jpaRepositoryClient = jpaRepositoryClient;
    }

    @Test
    public void getAllShouldReturnListOfClients() {
        Assert.assertEquals(clients, clientService.getAll());
    }

    @Test
    public void ifNicknameExistsShouldReturnTrueIfClientWithSuchNicknameExists() {
        Assert.assertTrue(clientService.ifNicknameExists(client.getNickname()));
    }

    @Test
    public void ifNicknameExistsShouldReturnFalseIfClientWithSuchNicknameDoesNotExist() {
        Assert.assertFalse(clientService.ifNicknameExists(""));
    }

    @Test
    public void ifEmailExistsShouldReturnTrueIfClientWithSuchEmailExists() {
        Assert.assertTrue(clientService.ifEmailExists(client.getEmail()));
    }

    @Test
    public void ifEmailExistsShouldReturnFalseIfClientWithSuchEmailDoesNotExist() {
        Assert.assertFalse(clientService.ifEmailExists(""));
    }

    @Test
    public void getClientByNicknameShouldReturnClientIfNicknameIsCorrect() {
        Assert.assertEquals(client, clientService.getClientByNickname(client.getNickname()));
    }

    @Test
    public void getClientByNicknameShouldReturnNullIfNicknameIsNotCorrect() {
        Assert.assertNull(clientService.getClientByNickname(""));
    }

    @Test
    public void getClientByIdShouldReturnCorrectClientIfIdExists() {
        Assert.assertEquals(client, clientService.getClientById(client.getId()));
    }

    @Test
    public void getClientByNicknameShouldReturnNullIfIdDoesNotCorrect() {
        Assert.assertNull(clientService.getClientById(client.getId() + 100));
    }

    @Test
    public void ifCorrectClientShouldReturnTrueIfCorrectIdAndPassword() {
        Assert.assertTrue(clientService.ifCorrectClient(client.getId(), client.getHashpassword()));
    }

    @Test
    public void ifCorrectClientShouldReturnFalseIfIdIsNotCorrect() {
        Assert.assertFalse(clientService.ifCorrectClient(client.getId() + 100, client.getHashpassword()));
    }

    @Test
    public void ifCorrectClientShouldReturnFalseIfPasswordIsNotCorrectForClientWithSuchId() {
        Assert.assertFalse(clientService.ifCorrectClient(client.getId(), ""));
    }

    @Test
    public void addNewClientShouldCallSaveMethodInRepository() {
        Client client2 = testData.getClient2();
        clientService.addNewClient(client2.getNickname(), client2.getEmail(), client2.getFirstname(),
                client2.getSurname(), client2.getCity(), client2.getPhone(), client2.getHashpassword(),
                client2.getAvatar());
        verify(jpaRepositoryClient).save(client2);
    }

    @Test
    public void updateClientShouldCallSaveMEthodInRepository() {
        clientService.updateClient(client.getId(), client.getNickname(),
                client.getEmail(), client.getFirstname(), client.getSurname(),
                client.getCity(), client.getPhone(), client.getHashpassword(),
                client.getAvatar());
        verify(jpaRepositoryClient).save(client);
    }
}
