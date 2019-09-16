package com.profile.generic.service;

import com.profile.generic.dto.ProfileDto;
import com.profile.generic.exception.GenericException;
import com.profile.generic.model.Profile;

public interface ProfileService {

    ProfileDto findById(long id)throws GenericException;
    ProfileDto findByName(String name)throws GenericException;
}
