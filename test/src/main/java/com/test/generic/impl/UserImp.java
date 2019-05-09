package com.test.generic.impl;
import com.test.generic.dto.UserDto;
import com.test.generic.exception.GenericException;
import com.test.generic.model.User;
import com.test.generic.repository.UserRepository;
import com.test.generic.service.UserService;
import com.test.generic.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Sebastian Gonzalez
 */

@Service
public class UserImp implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserImp.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findByEmailInAndPassword(String email, String password) throws GenericException {
        try {
            return getEmailAndPassword(userRepository.findByEmailInAndPassword(email,password));
        }catch (GenericException ex){
            logger.error(ex.getMessage(),ex);
            throw new GenericException(Constant.ERROR_GET_USER,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private UserDto getEmailAndPassword(Optional<User> user){
        UserDto userDto = new UserDto();
        if(user.isPresent()){
            userDto.setIdDto(user.get().getId());
            userDto.setFirstNameDto(user.get().getFirstName());
            userDto.setLastNameDto(user.get().getLastName());
            userDto.setSecondLastNameDto(user.get().getSecondLastName());
            userDto.setEmailDto(user.get().getEmail());
            userDto.setPhoneNumberDto(user.get().getPhoneNumber());
            userDto.setPasswordDto(user.get().getPassword());
            userDto.setCreationDateDto(user.get().getCreationDate());
            userDto.setUpdateDatesDto(user.get().getUpdateDates());
            userDto.setActiveDto(user.get().getActive());
        }else{
            userDto = null;
        }
        return userDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) throws GenericException {
        try {
            User user = transformUserDtoToUser(userDto);
            userRepository.save(user);
            return transformUserToDtoUser(user);
        }catch (GenericException ex){
            logger.error(ex.getMessage(),ex);
            throw new GenericException(Constant.ERROR_GET_USER,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public User transformUserDtoToUser(UserDto userDto)throws GenericException{
        User user = new User();
        try {
            if(null != userDto){
                user.setFirstName(userDto.getFirstNameDto());
                user.setLastName(userDto.getLastNameDto());
                user.setSecondLastName(userDto.getSecondLastNameDto());
                user.setEmail(userDto.getEmailDto());
                user.setPhoneNumber(userDto.getPhoneNumberDto());
                user.setPassword(userDto.getPasswordDto());
                user.setCreationDate(userDto.getCreationDateDto());
                user.setUpdateDates(userDto.getUpdateDatesDto());
                user.setActive(userDto.getActiveDto());
            }else{
                user = null;
            }
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new GenericException(Constant.ERROR_TRANSFORM_DTO_USER,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return user;
    }

    public UserDto transformUserToDtoUser(User user)throws GenericException{
        UserDto userDto = new UserDto();
        try {
            if(null != user){
                userDto.setIdDto(user.getId());
                userDto.setFirstNameDto(user.getFirstName());
                userDto.setLastNameDto(user.getLastName());
                userDto.setSecondLastNameDto(user.getSecondLastName());
                userDto.setEmailDto(user.getEmail());
                userDto.setPhoneNumberDto(user.getPhoneNumber());
                userDto.setPasswordDto(user.getPassword());
                userDto.setCreationDateDto(user.getCreationDate());
                userDto.setUpdateDatesDto(user.getUpdateDates());
                userDto.setActiveDto(user.getActive());
            }else{
                userDto = null;
            }
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new GenericException(Constant.ERROR_TRANSFORM_MODEL_USER,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return userDto;
    }

}
