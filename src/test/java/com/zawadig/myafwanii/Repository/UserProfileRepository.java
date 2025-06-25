package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    // Badilisha hii line:
    // Optional<UserProfile> findByEmail(String email);

    // Na iwe ifuatayo:
    Optional<UserProfile> findByUserEmail(String email);
}
