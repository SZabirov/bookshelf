package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface JpaRepositoryUsers extends JpaRepository<Users, Integer> {

    List<Users> findAll();

    Users findOneById(int id);

    Users findOneByNickname(String nickname);

    Users findOneByEmail(String email);

    List<Users> findAllByCity(String city);
// FIXME: 20.05.2016
//    @Query("select u from Users u order by u.nickname asc")
//    List<Users> findAllOrderbyNicknameAsc();
//
//    List<Users> findAllOrderbySurnameAndFirstname();

}
