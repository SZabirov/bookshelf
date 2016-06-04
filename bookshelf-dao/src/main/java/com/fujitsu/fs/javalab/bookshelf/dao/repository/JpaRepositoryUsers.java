package com.fujitsu.fs.javalab.bookshelf.dao.repository;

import com.fujitsu.fs.javalab.bookshelf.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aygulmardanova on 08.05.16.
 */
@Repository
public interface JpaRepositoryUsers extends JpaRepository<Users, Integer> {

    Users findById(int id);

    Users findByNickname(String nickname);

    Users findByEmail(String email);
}
