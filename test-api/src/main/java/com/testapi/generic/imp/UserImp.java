package com.testapi.generic.imp;

import com.testapi.generic.dto.UserDto;
import com.testapi.generic.dto.req.UserReqDto;
import com.testapi.generic.exception.GenericException;
import com.testapi.generic.util.Constant;
import com.testapi.generic.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

/**
 * Sebastian Gonzalez
 */

@Service
public class UserImp implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserImp.class);

    @Value("${dist.service.dal.url}")
    private String dalServiceUrlTest;

    @Override
    public UserDto findByEmailInAndPassword(UserReqDto userReqDto) throws GenericException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto> responseEntity = null;
        UserDto userDtoLocal = null;
        try {

            HttpEntity<UserReqDto> requestEntity = new HttpEntity<>(userReqDto);
            logger.info(Constant.URL +dalServiceUrlTest + Constant.URLTESTDAL);

            responseEntity = restTemplate.exchange(dalServiceUrlTest + Constant.URLTESTDAL,
                    HttpMethod.POST, requestEntity, UserDto.class);

            if (null == responseEntity) {
                logger.error(Constant.ERROR_CLIENT_USER);
                throw new GenericException(Constant.ERROR_GET_USER,
                        HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                userDtoLocal = responseEntity.getBody();
            }


        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new GenericException(Constant.ERROR_GET_USER,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return userDtoLocal;
    }

    @Override
    public UserDto addUser(UserDto userDto) throws GenericException {
        return null;
    }
}
