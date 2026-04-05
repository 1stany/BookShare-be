package org.projectwork.reshare.model.repositories.abstractions;

import org.projectwork.reshare.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
