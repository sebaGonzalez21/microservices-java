package com.profile.generic.controller;

import com.profile.generic.exception.GenericException;
import com.profile.generic.service.ProfileService;
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
@RequestMapping("/dal/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @ApiOperation(value = "Obtiene un perfil",
            notes="Perfil de usuario")
    @RequestMapping(method = RequestMethod.GET,value="/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>( profileService.findById(id), HttpStatus.OK);
        }catch (GenericException genericException){
            logger.error(genericException.getMessage(),genericException);
            rs = new ResponseEntity<>( genericException.getMessage(), genericException.getHttpStatus());
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            rs = new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @ApiOperation(value = "Obtiene un perfil mediante el nombre de usuario",
            notes="Perfil mediante el nombre de usuario")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findByName(@RequestParam String name){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>( profileService.findByName(name), HttpStatus.OK);
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
