package com.elta.elta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elta.elta.entities.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

}
