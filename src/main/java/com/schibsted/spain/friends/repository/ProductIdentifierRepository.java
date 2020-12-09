package com.schibsted.spain.friends.repository;

import com.schibsted.spain.friends.model.ProductIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductIdentifierRepository extends JpaRepository<ProductIdentifier, Long> {

    @Query(value = "SELECT t FROM ProductIdentifier t where t.urlQrId = :urlQrId")
    public List<ProductIdentifier> findByUrlQrId(String urlQrId);
}
