package com.profile.generic.repository;

import com.profile.generic.model.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Implementa metodos crud
 */
public interface ProfileRepository extends CrudRepository<Profile,Long> {
    Optional<Profile> findByName(String name);
}
