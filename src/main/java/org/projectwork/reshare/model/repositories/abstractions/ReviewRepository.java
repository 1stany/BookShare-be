package org.projectwork.reshare.model.repositories.abstractions;

import org.projectwork.reshare.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
