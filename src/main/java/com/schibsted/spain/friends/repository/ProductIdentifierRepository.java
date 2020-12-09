package com.schibsted.spain.friends.repository;

import com.schibsted.spain.friends.model.ProductIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductIdentifierRepository extends JpaRepository<ProductIdentifier, Long> {
    public List<ProductIdentifier> findByUrlQrId(String urlQrId);
}
