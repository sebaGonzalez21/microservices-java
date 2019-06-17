package com.test.generic.repository;

import com.test.generic.exception.GenericException;
import com.test.generic.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Sebastian Gonzalez
 */

public interface UserRepository extends PagingAndSortingRepository<User,Long> {

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws GenericException
     */
    Optional<User> findByEmailInAndPassword(String email,String password)throws GenericException;

}
