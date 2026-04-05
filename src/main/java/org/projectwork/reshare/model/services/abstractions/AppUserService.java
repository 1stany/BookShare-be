package org.projectwork.reshare.model.services.abstractions;

import org.projectwork.reshare.exceptions.EntityNotFoundException;
import org.projectwork.reshare.model.AppUser;
import org.projectwork.reshare.model.City;

public interface AppUserService {
    AppUser saveUser(AppUser u);

    AppUser getUserById(long id) throws EntityNotFoundException;

    AppUser getUserByEmail(String email);

    City getCityByName(String name);

    AppUser updateUserCity(long userId, long cityId) throws EntityNotFoundException;
}
