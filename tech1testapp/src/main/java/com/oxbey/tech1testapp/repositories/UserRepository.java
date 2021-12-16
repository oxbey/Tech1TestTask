package com.oxbey.tech1testapp.repositories;

import com.oxbey.tech1testapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<List<UserEntity>> findAllByAgeAfter(int age);
}
