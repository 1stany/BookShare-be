package org.projectwork.reshare.model.repositories.abstractions;

import org.projectwork.reshare.dto.AppUserDto;
import org.projectwork.reshare.model.AppUser;
import org.projectwork.reshare.model.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
    List<ItemType> findAllById(long id);
    List<ItemType> findByWishingUser(AppUser user);
}
