package com.schibsted.spain.realCustomer.repository;

import com.schibsted.spain.realCustomer.model.Recording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingRepository extends JpaRepository<Recording, Long> {
    
}
