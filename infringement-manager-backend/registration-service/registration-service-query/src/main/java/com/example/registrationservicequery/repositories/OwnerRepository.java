package com.example.registrationservicequery.repositories;

import com.example.registrationservicequery.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,String> {
    Optional<Owner> findByCIN(String CIN);
}
