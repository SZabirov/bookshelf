//package com.fujitsu.fs.javalab.bookshelf.dao.repository;
//
//import com.fujitsu.fs.javalab.bookshelf.models.Author;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class AuthorRepositoryTest {
//
//    private static AuthorRepository authorRepository;
//
//    @BeforeClass
//    public static void prepareData() {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("repository-config.xml");
//        authorRepository = ctx.getBean(AuthorRepository.class);
//    }
//
//    @Test
//    public void findAllMethodShouldReturnNotEmptyList() {
//        Assert.assertNotNull(authorRepository.findAll());
//    }
//
//    @Test
//    public void findByIdMethodShouldReturnAuthor() {
//        Author author1 = authorRepository.findById(1);
//        Author author2 = mock(Author.class);
//        when(author2.getId()).thenReturn(1);
//        Assert.assertEquals(author1.getId(), author2.getId());
//    }
//
//    // TODO: 04.06.2016 test findAllByFirstnameAndSurname
//    @Test
//    public void findByFirstnameAndSurnameMethodShouldReturnAuthor() {
////        Author author1 = authorRepository.findByFirstnameAndSurname("Лев", "Толстой");
////        Author author2 = mock(Author.class);
////        when(author2.getFirstname()).thenReturn("Лев");
////        when(author2.getSurname()).thenReturn("Толстой");
////        Assert.assertEquals(author1.getFirstname(), author2.getFirstname());
////        Assert.assertEquals(author1.getSurname(), author2.getSurname());
//    }
//
//    @Test
//    public void findByFirstnameSurnameAndMiddlenameMethodShouldReturnAuthor() {
//        Author author1 = authorRepository.findByFirstnameAndSurnameAndMiddlename("Лев", "Толстой", "Николаевич");
//        Author author2 = mock(Author.class);
//        when(author2.getFirstname()).thenReturn("Лев");
//        when(author2.getSurname()).thenReturn("Толстой");
//        when(author2.getMiddlename()).thenReturn("Николаевич");
//        Assert.assertEquals(author1.getFirstname(), author2.getFirstname());
//        Assert.assertEquals(author1.getSurname(), author2.getSurname());
//        Assert.assertEquals(author1.getMiddlename(), author2.getMiddlename());
//    }
//
//}
