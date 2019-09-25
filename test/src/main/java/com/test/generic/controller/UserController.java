package com.test.generic.controller;

import com.test.generic.dto.UserDto;
import com.test.generic.dto.req.PageableUserDto;
import com.test.generic.dto.req.UserReqDto;
import com.test.generic.exception.GenericException;
import com.test.generic.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Sebastian Gonzalez
 */

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/dal/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Registra un usuario",
            notes="Agrega usuario")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestBody UserDto userDto){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>( userService.addUser(userDto), HttpStatus.OK);
        }catch (GenericException genericException){
            logger.error(genericException.getMessage(),genericException);
            rs = new ResponseEntity<>( genericException.getMessage(), genericException.getHttpStatus());
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            rs = new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @ApiOperation(value = "lista usuarios creados paginados",
            notes="lista usuarios creados paginados")
    @RequestMapping(method = RequestMethod.POST,value = "/pageable")
    public ResponseEntity<Object> findAllO(@RequestBody PageableUserDto pageableUserDto){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>( userService.findAllO(pageableUserDto), HttpStatus.OK);
        }catch (GenericException genericException){
            logger.error(genericException.getMessage(),genericException);
            rs = new ResponseEntity<>( genericException.getMessage(), genericException.getHttpStatus());
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            rs = new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @ApiOperation(value = "lista usuarios creados paginados",
            notes="lista usuarios creados paginados")
    @RequestMapping(method = RequestMethod.GET, value="/pageable")
    public ResponseEntity<Object> findAll(@RequestParam int actualPage,@RequestParam int quantityRows ){
        ResponseEntity<Object> rs = null;
        try {
            PageableUserDto pageableUserDto = new PageableUserDto();
            if(0 >= actualPage && 1>= quantityRows){
                pageableUserDto.setActualPage(actualPage);
                pageableUserDto.setQuantityRows(quantityRows);
            }else{
                pageableUserDto.setActualPage(0);
                pageableUserDto.setQuantityRows(10);
            }

            rs = new ResponseEntity<Object>( userService.findAll(pageableUserDto), HttpStatus.OK);
        }catch (GenericException genericException){
            logger.error(genericException.getMessage(),genericException);
            rs = new ResponseEntity<>( genericException.getMessage(), genericException.getHttpStatus());
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            rs = new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @ApiOperation(value = "Inicia Sesion",
            notes="Inicio de Sesion de Usuario")
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public ResponseEntity<Object> addUser(@RequestBody UserReqDto userReqDto){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>( userService.findByEmailInAndPassword(userReqDto.getEmailDto(),userReqDto.getPasswordDto()), HttpStatus.OK);
        }catch (GenericException genericException){
            logger.error(genericException.getMessage(),genericException);
            rs = new ResponseEntity<>( genericException.getMessage(), genericException.getHttpStatus());
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            rs = new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

}
