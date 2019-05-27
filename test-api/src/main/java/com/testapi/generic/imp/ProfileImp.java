package com.testapi.generic.imp;

import com.testapi.generic.dto.ProfileDto;
import com.testapi.generic.dto.UserDto;
import com.testapi.generic.dto.req.UserReqDto;
import com.testapi.generic.exception.GenericException;
import com.testapi.generic.service.ProfileService;
import com.testapi.generic.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Sebastian Gonzalez
 */

@Service
public class ProfileImp implements ProfileService {

    private static final Logger logger = LoggerFactory.getLogger(ProfileImp.class);

    @Value("${dist.service.dal.urlProfile}")
    private String dalServiceUrlProfile;


    @Override
    public ProfileDto findById(long id) throws GenericException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProfileDto> responseEntity = null;
        ProfileDto profileDtoLocal = null;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        try {

            logger.info(Constant.URL +dalServiceUrlProfile + Constant.URLPROFILEDAL + id);

            responseEntity = restTemplate.exchange(dalServiceUrlProfile + Constant.URLPROFILEDAL + id,
                    HttpMethod.GET,requestEntity,ProfileDto.class);
            if (null == responseEntity) {
                logger.error(Constant.ERROR_CLIENT_USER);
                throw new GenericException(Constant.ERROR_GET_PROFILE,
                        HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                profileDtoLocal = responseEntity.getBody();
            }


        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new GenericException(Constant.ERROR_GET_PROFILE,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return profileDtoLocal;
    }




}
