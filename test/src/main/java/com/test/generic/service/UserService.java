package com.test.generic.service;
import com.test.generic.dto.PageableUserListDto;
import com.test.generic.dto.UserDto;
import com.test.generic.dto.req.PageableUserDto;
import com.test.generic.exception.GenericException;
import com.test.generic.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

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

    Page<User> findAll(PageableUserDto pageableUserDto) throws GenericException;

     PageableUserListDto findAllO(PageableUserDto pageableUserDto)throws GenericException;

}
