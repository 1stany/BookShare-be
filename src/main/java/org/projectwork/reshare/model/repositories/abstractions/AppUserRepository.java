package org.projectwork.reshare.model.repositories.abstractions;

import org.projectwork.reshare.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
