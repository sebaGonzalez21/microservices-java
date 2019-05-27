package com.testapi.generic.service;
import com.testapi.generic.dto.ProfileDto;
import com.testapi.generic.exception.GenericException;

/**
 * Sebastian Gonzalez
 */
public interface ProfileService {

    ProfileDto findById(long id)throws GenericException;
}
