package com.testapi.generic.controller;
import com.testapi.generic.dto.ProfileDto;
import com.testapi.generic.dto.req.PageableUserDto;
import com.testapi.generic.service.ProfileService;
import com.testapi.generic.util.Constant;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.testapi.generic.exception.GenericException;
import com.testapi.generic.dto.req.UserReqDto;
import com.testapi.generic.dto.UserDto;
import com.testapi.generic.service.UserService;
import org.springframework.web.multipart.MultipartFile;


/**
 * Sebastian Gonzalez
 */

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;

    /**
     * Agregar Usuario
     * @param userDto
     * @return
     */
    @ApiOperation(value = "Buusca un usuario y agrega",
            notes="Buusca un usuario y agrega")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> findById(@RequestBody UserDto userDto){
        ResponseEntity<Object> rs = null;
        ProfileDto profileDto = null;
        try {
            profileDto = profileService.findById(userDto.getProfileDto());
            if(null != profileDto){
                rs = new ResponseEntity<Object>( userService.addUser(userDto), HttpStatus.OK);
            }else{
                rs = new ResponseEntity<Object>(Constant.ERROR_GET_PROFILE,HttpStatus.BAD_REQUEST);
            }

        }catch (GenericException genericException){
            logger.error(genericException.getMessage(),genericException);
            rs = new ResponseEntity<>( genericException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            rs = new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    /**
     * Lista de Usuarios
     * @param pageableUserDto
     * @return
     */
    @ApiOperation(value = "Lista de Usuarios",
            notes="Lista de Usuarios")
    @RequestMapping(method = RequestMethod.POST, value = "/pageable")
    public ResponseEntity<Object> findAllO(@RequestBody PageableUserDto pageableUserDto){
        ResponseEntity<Object> rs = null;
        ProfileDto profileDto = null;
        try {
            rs = new ResponseEntity<Object>( userService.findAllO(pageableUserDto), HttpStatus.OK);

        }catch (GenericException genericException){
            logger.error(genericException.getMessage(),genericException);
            rs = new ResponseEntity<>( genericException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            rs = new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }


    @ApiOperation(value = "Metodo de guardado de archivos",
            notes="meotodo de guardado de archivos")
    @RequestMapping(method = RequestMethod.POST,value = "/file")
    public ResponseEntity<Object> saveFile(@RequestParam("file") MultipartFile file){
        //UserReqDto userReqDto = new UserReqDto();
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>( userService.saveFile(file), HttpStatus.OK);
        }catch (GenericException genericException){
            logger.error(genericException.getMessage(),genericException);
            rs = new ResponseEntity<>( genericException.getMessage(), genericException.getHttpStatus());
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            rs = new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    /**
     * Busqueda de Email
     * @param userReqDto
     * @return
     */
    @ApiOperation(value = "Inicia Sesion api",
            notes="Inicio de Sesion de Usuario api")
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public ResponseEntity<Object> findByEmailInAndPassword(@RequestBody UserReqDto userReqDto){
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
