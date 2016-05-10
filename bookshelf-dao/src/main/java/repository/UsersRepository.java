package repository;

import com.fujitsu.fs.javalab.bookshelf.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {

    List<Users> findAll();

    Users findOneById(int id);

    Users findOneByNickname(String nickname);

    List<Users> findAllByCity(String city);

//    @Query("select u from Users u order by u.nickname asc")
    List<Users> findAllOrderbyNicknameAsc();

    List<Users> findAllOrderbySurnameAndFirstname();

}
