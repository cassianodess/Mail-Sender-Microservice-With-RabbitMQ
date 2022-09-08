package com.cassianodess.ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassianodess.ms.models.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{
    
}
