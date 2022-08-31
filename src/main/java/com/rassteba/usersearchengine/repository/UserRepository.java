package com.rassteba.usersearchengine.repository;

import com.rassteba.usersearchengine.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
