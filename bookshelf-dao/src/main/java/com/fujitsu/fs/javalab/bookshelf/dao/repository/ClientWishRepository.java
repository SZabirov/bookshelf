package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.AuthorBookname;
import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.models.ClientWish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface ClientWishRepository extends JpaRepository<ClientWish, Integer> {

    List<ClientWish> findAll();

    ClientWish findById(int id);

    ClientWish findByClientAndAuthorBookname(Client client, AuthorBookname authorBookname);

    List<ClientWish> findAllByClient(Client client);
}
