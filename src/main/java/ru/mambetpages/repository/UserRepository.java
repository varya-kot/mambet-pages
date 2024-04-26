package ru.mambetpages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mambetpages.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
