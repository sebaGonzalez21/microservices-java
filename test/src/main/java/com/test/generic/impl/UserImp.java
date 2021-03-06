package com.test.generic.impl;
import com.test.generic.dto.PageableUserListDto;
import com.test.generic.dto.UserDto;
import com.test.generic.dto.req.PageableUserDto;
import com.test.generic.exception.GenericException;
import com.test.generic.model.User;
import com.test.generic.repository.UserRepository;
import com.test.generic.service.UserService;
import com.test.generic.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        try{
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
                userDto.setProfileDto(user.get().getProfile());
            }else{
                userDto = null;
            }
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
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

    @Override
    public Page<User> findAll(PageableUserDto pageableUserDto) {
          Page<User> listUser = null;
        try {
            Pageable firstPageWithTwoElements = PageRequest.of(pageableUserDto.getActualPage(), pageableUserDto.getQuantityRows());
            listUser =userRepository.findAll(firstPageWithTwoElements);

        }catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
        }
        return listUser;
    }

    @Override
    public PageableUserListDto findAllO(PageableUserDto pageableUserDto){
        PageableUserListDto pageableUserListDto = new PageableUserListDto();
        Page<User> listUser = null;
        UserDto userDto = null;
        try {
            Pageable firstPageWithTwoElements = PageRequest.of(pageableUserDto.getActualPage(), pageableUserDto.getQuantityRows());
            listUser = userRepository.findAll(firstPageWithTwoElements);

            if(listUser.getNumberOfElements()>0){
                for (User userObj: listUser){
                    userDto = new UserDto();
                    userDto.setIdDto(userObj.getId());
                    userDto.setFirstNameDto(userObj.getFirstName());
                    userDto.setLastNameDto(userObj.getLastName());
                    userDto.setSecondLastNameDto(userObj.getSecondLastName());
                    userDto.setEmailDto(userObj.getEmail());
                    userDto.setPhoneNumberDto(userObj.getPhoneNumber());
                    userDto.setPasswordDto(userObj.getPassword());
                    userDto.setCreationDateDto(userObj.getCreationDate());
                    userDto.setUpdateDatesDto(userObj.getUpdateDates());
                    userDto.setActiveDto(userObj.getActive());
                    userDto.setProfileDto(userObj.getProfile());
                    pageableUserListDto.getUserDtoList().add(userDto);
                }

                pageableUserListDto.setCurrentPage(listUser.getPageable().getPageNumber());
                pageableUserListDto.setItemPerPage(listUser.getNumberOfElements());
                pageableUserListDto.setTotalPages(listUser.getTotalPages());
                pageableUserListDto.setQuantityRecords(listUser.getNumberOfElements());

            }



        }catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
        }

        return pageableUserListDto;
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
                user.setProfile(userDto.getProfileDto());
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
                userDto.setProfileDto(user.getProfile());
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
