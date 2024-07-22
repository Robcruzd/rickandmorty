package com.test.infrastructure.jpa.repositories;

import com.test.infrastructure.jpa.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationJpaRepository extends JpaRepository<LocationEntity, Integer> {
}
