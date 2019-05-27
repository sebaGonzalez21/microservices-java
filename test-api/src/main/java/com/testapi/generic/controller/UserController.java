package com.testapi.generic.controller;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.testapi.generic.exception.GenericException;
import com.testapi.generic.dto.req.UserReqDto;
import com.testapi.generic.dto.UserDto;
import com.testapi.generic.service.UserService;


/**
 * Sebastian Gonzalez
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Registra un usuario api",
            notes="Agrega usuario api")
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

    @ApiOperation(value = "Inicia Sesion api",
            notes="Inicio de Sesion de Usuario api")
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public ResponseEntity<Object> addUser(@RequestBody UserReqDto userReqDto){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>( userService.findByEmailInAndPassword(userReqDto), HttpStatus.OK);
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
