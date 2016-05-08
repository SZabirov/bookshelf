package repository;

import model.Book;
import model.Users;
import model.UsersHaving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface UsersHavingRepository extends JpaRepository<UsersHaving, Integer> {

    List<UsersHaving> findAll();

    UsersHaving findOneById(int id);

    List<UsersHaving> findAllByUsers(Users users);

    List<UsersHaving> findAllByBook(Book book);

    UsersHaving findOneByUsersAndBook(Users users, Book book);
}
