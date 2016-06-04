package com.fujitsu.fs.javalab.bookshelf.service;

import com.fujitsu.fs.javalab.bookshelf.dao.repository.JpaRepositoryAuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Author;
import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.verify;

/**
 *
 */
public class AuthorBooknameServiceImplTest {

    private static TestData testData;

    private static Author author;
    private static AuthorBookname authorBookname;

    private static AuthorBooknameServiceImpl authorBooknameService;

    private static JpaRepositoryAuthorBookname jpaRepositoryAuthorBookname;

    @BeforeClass
    public static void beforeClassMethod() {
        testData = new TestData();
        author = testData.getAuthor();
        authorBookname = testData.getAuthorBookname();

        jpaRepositoryAuthorBookname = testData.getJpaRepositoryAuthorBookname();

        authorBooknameService = new AuthorBooknameServiceImpl();
        authorBooknameService.jpaRepositoryAuthorBookname = jpaRepositoryAuthorBookname;
    }

    @Test
    public void getAllMethodShouldReturnCorrectListOfAuthorBooknames() {
        Assert.assertEquals(testData.getAuthorBooknames(), authorBooknameService.getAll());
    }

    @Test
    public void getAllByAuthorShouldReturnNonEmptyListIfAuthorExists() {
        Assert.assertEquals(testData.getAuthorBooknames(), authorBooknameService.getAllByAuthor(author));
    }

    @Test
    public void getAllByAuthorShouldReturnNullIfAuthorDoesNotExist() {
        Assert.assertNull(authorBooknameService.getAllByAuthor(new Author()));
    }

    @Test
    public void getAllByBooknameShouldReturnNonEmptyListIfBooknameExists() {
        Assert.assertEquals(testData.getAuthorBooknames(), authorBooknameService.getAllByBookname(authorBookname.getBookname()));
    }

    @Test
    public void getAllByBooknameShouldReturnNullIfBooknameDoesNotExist() {
        Assert.assertNull(authorBooknameService.getAllByBookname(""));
    }

    @Test
    public void getAllByAuthorAndBooknameShouldReturnCorrectListIfCorrectData() {
        Assert.assertEquals(testData.getAuthorBooknames(), authorBooknameService.getAllByAuthorAndBookname(author, authorBookname.getBookname()));
    }

    @Test
    public void getAllByAuthorAndBooknameShouldReturnNullIfNoBooksWithSuchBookname() {
        Assert.assertNull(authorBooknameService.getAllByAuthorAndBookname(author, ""));
    }

    @Test
    public void getAllByAuthorAndBooknameShouldReturnNullIfNoBooksForAuthor() {
        Assert.assertNull(authorBooknameService.getAllByAuthorAndBookname(new Author(), authorBookname.getBookname()));
    }

    @Test
    public void getAllByAuthorAndBooknameShouldReturnNullIfNoBooksWithThisParameters() {
        Assert.assertNull(authorBooknameService.getAllByAuthorAndBookname(new Author(), ""));
    }

    @Test
    public void getOneByAuthorAndBooknameShouldReturnCorrectAuthorBooknameIfCorrectData() {
        Assert.assertEquals(authorBookname, authorBooknameService.getOneByAuthorAndBookname(author, authorBookname.getBookname()));
    }

    @Test
    public void getOneByAuthorAndBooknameShouldReturnNullIfNoBooksWithSuchBookname() {
        Assert.assertNull(authorBooknameService.getOneByAuthorAndBookname(author, ""));
    }

    @Test
    public void getOneByAuthorAndBooknameShouldReturnNullIfNoBooksForAuthor() {
        Assert.assertNull(authorBooknameService.getOneByAuthorAndBookname(new Author(), authorBookname.getBookname()));
    }

    @Test
    public void getOneByAuthorAndBooknameShouldReturnNullIfNoBooksWithThisParameters() {
        Assert.assertNull(authorBooknameService.getOneByAuthorAndBookname(new Author(), ""));
    }

    @Test
    public void addAuthorBooknameShouldCallSaveMethodIfNotExistsAuthorBookname() {
        AuthorBookname authorBookname1 = new AuthorBookname();
        authorBooknameService.addAuthorBookname(authorBookname1);
        verify(jpaRepositoryAuthorBookname).save(authorBookname1);
    }

    @Test
    public void addAuthorBooknameShouldReturnAuthorBooknameIfExists() {
        Assert.assertEquals(authorBookname, authorBooknameService.addAuthorBookname(authorBookname));
    }
}
