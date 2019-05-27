package com.profile.generic.service;

import com.profile.generic.dto.ProfileDto;
import com.profile.generic.exception.GenericException;

public interface ProfileService {

    ProfileDto findById(long id)throws GenericException;
}
