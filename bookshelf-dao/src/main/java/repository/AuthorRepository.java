package repository;

import com.fujitsu.fs.javalab.bookshelf.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAll();

    Author findOneById(int id);

    Author findOneByFirstnameAndSurnameAndMiddlename(String firstname,
                                                     String surname, String middlename);

    @Query("select a from Author a order by a.surname, a.firstname asc")
    List<Author> findAllOrderbySurnameAndFirstname();
}
