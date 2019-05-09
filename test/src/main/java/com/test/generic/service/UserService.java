package com.test.generic.service;
import com.test.generic.dto.UserDto;
import com.test.generic.exception.GenericException;

/**
 * Sebastian Gonzalez
 */
public interface UserService {

    /**
     * find user system by email and password
     * @return
     * @throws GenericException
     */
    UserDto findByEmailInAndPassword(String email,String password) throws GenericException;

    /**
     * add user to system
     * @return
     * @throws GenericException
     */
    UserDto addUser(UserDto userDto) throws GenericException;

}
