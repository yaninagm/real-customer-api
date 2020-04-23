package com.schibsted.spain.friends.repository;

import com.schibsted.spain.friends.model.Recording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingRepository extends JpaRepository<Recording, Long> {
    
}
