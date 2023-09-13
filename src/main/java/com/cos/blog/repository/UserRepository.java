package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);

}






//JPA Naming 쿼리 전략
//SELECT*FROM user WHERE username=?1 AND password=?2;
//    User findByEmailAndPassword(String email, String password);

//    @Query(value="SELECT*FROM user WHERE username=?1 AND password=?2",nativeQuery = true)
//    User login(String username, String password);