package ru.mambetpages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mambetpages.entity.UserProfile;

import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
}
