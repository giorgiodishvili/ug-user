package org.ug.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ug.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
