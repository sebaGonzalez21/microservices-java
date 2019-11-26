package com.test.generic.repository;

import com.test.generic.exception.GenericException;
import com.test.generic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Sebastian Gonzalez
 */

public interface UserRepository extends JpaRepository<User,Long> {

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws GenericException
     */
    Optional<User> findByEmailInAndPassword(String email,String password)throws GenericException;

}
