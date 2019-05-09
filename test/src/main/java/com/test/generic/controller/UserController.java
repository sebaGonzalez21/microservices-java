package com.test.generic.controller;

import com.test.generic.dto.UserDto;
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
@RequestMapping("/api/user")
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


}
