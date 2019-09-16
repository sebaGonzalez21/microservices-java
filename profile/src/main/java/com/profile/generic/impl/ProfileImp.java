package com.profile.generic.impl;

import com.profile.generic.dto.ProfileDto;
import com.profile.generic.exception.GenericException;
import com.profile.generic.model.Profile;
import com.profile.generic.repository.ProfileRepository;
import com.profile.generic.service.ProfileService;
import com.profile.generic.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Sebastian Gonzalez
 */

@Service
public class ProfileImp implements ProfileService {

    private static final Logger logger = LoggerFactory.getLogger(ProfileImp.class);
    @Autowired
    private ProfileRepository profileRepository;


    @Override
    public ProfileDto findById(long id) throws GenericException {
        try {
            return transformProfileOptionalToDto(profileRepository.findById(id));
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            throw new GenericException(Constant.ERROR_GET_PROFILE,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ProfileDto findByName(String name) throws GenericException {
        ProfileDto profileDto = null;
        try {
            profileDto = transformProfileOptionalToDto(profileRepository.findByName(name));
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
        }
        return profileDto;
    }

    

    public ProfileDto transformProfileOptionalToDto(Optional<Profile> profile){
        ProfileDto profileDto = null;
        try{
            if(profile.isPresent()){
                profileDto = new ProfileDto();
                profileDto.setIdDto(profile.get().getId());
                profileDto.setNameDto(profile.get().getName());
                profileDto.setFlagActivateDto(profile.get().getFlagActivate());
            }
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
        }
        return profileDto;
    }

    private Profile transformDtoIntoProfile(ProfileDto profileDto){
        Profile profile = null;
        try {
            profileDto = new ProfileDto();
            profile.setFlagActivate(profileDto.getFlagActivateDto());
            profile.setName(profileDto.getNameDto());
            profile.setId(profileDto.getIdDto());

        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
        }
        return profile;
    }

    private ProfileDto transformProfileIntoDto(Profile profile){
        ProfileDto profileDto = null;
        try {
            profileDto = new ProfileDto();
            profileDto.setFlagActivateDto(profile.getFlagActivate());
            profileDto.setNameDto(profile.getName());
            profileDto.setIdDto(profile.getId());
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
        }
        return profileDto;
    }

}
