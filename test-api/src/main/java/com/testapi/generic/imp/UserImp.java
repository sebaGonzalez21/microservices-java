package com.testapi.generic.imp;

import com.testapi.generic.dto.FileDto;
import com.testapi.generic.dto.UserDto;
import com.testapi.generic.dto.req.PageableUserDto;
import com.testapi.generic.dto.req.PageableUserListDto;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<UserReqDto> requestEntity = new HttpEntity<>(userReqDto,headers);
        try {


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
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto> responseEntity = null;
        UserDto userDtoLocal = null;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<UserDto> requestEntity = new HttpEntity<>(userDto,headers);
        try {


            logger.info(Constant.URL +dalServiceUrlTest + Constant.URLTESTDAL);

            responseEntity = restTemplate.exchange(dalServiceUrlTest + Constant.URL_USER_SAVE,
                    HttpMethod.POST, requestEntity, UserDto.class);

            if (null == responseEntity) {
                logger.error(Constant.ERROR_CLIENT_USER);
                throw new GenericException(Constant.ERROR_SAVE_USER,
                        HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                userDtoLocal = responseEntity.getBody();
            }


        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new GenericException(Constant.ERROR_SAVE_USER,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return userDtoLocal;
    }

    @Override
    public PageableUserListDto findAllO(PageableUserDto pageableUserDto) throws GenericException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PageableUserListDto> responseEntity = null;
        PageableUserListDto userDtoLocalList = new PageableUserListDto();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<PageableUserDto> requestEntity = new HttpEntity<>(pageableUserDto,headers);
        try {


            logger.info(Constant.URL +dalServiceUrlTest + Constant.URLTESTDAL_LIST);

            responseEntity = restTemplate.exchange(dalServiceUrlTest + Constant.URLTESTDAL_LIST,
                    HttpMethod.POST, requestEntity, PageableUserListDto.class);

            if (null == responseEntity) {
                logger.error(Constant.ERROR_CLIENT_LIST);
                throw new GenericException(Constant.ERROR_LIST_USER,
                        HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                userDtoLocalList = responseEntity.getBody();
            }


        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new GenericException(Constant.ERROR_SAVE_USER,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return userDtoLocalList;
    }

    @Override
    public FileDto saveFile(MultipartFile file) throws GenericException{
        FileDto fileDto = new FileDto();
        try {

            File fileMetadata = new File;
            fileMetadata.setName("photo.jpg");
            java.io.File filePath = new java.io.File("files/photo.jpg");
            FileContent mediaContent = new FileContent("image/jpeg", filePath);
            File file = driveService.files().create(fileMetadata, mediaContent)
                    .setFields("id")
                    .execute();
            System.out.println("File ID: " + file.getId());

        }catch (Exception ex){
            throw new GenericException(Constant.ERROR_SAVE_FILE,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return fileDto;
    }
}
