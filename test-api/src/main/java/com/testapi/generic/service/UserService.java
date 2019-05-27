package com.testapi.generic.service;
import com.testapi.generic.dto.UserDto;
import com.testapi.generic.dto.req.UserReqDto;
import com.testapi.generic.exception.GenericException;

/**
 * Sebastian Gonzalez
 */

public interface UserService {

    /**
     * find user system by email and password
     * @return
     * @throws GenericException
     */
    UserDto findByEmailInAndPassword(UserReqDto userReqDto) throws GenericException;

    /**
     * add user to system
     * @return
     * @throws GenericException
     */
    UserDto addUser(UserDto userDto) throws GenericException;


}
