package com.schibsted.spain.friends.repository;

import com.schibsted.spain.friends.model.ProductIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductIdentifierRepository extends JpaRepository<ProductIdentifier, Long> {

    @Query(value = "SELECT p FROM ProductIdentifier p where p.urlQrId = :urlQrId")
    public ProductIdentifier findByUrlQrId(String urlQrId);
}
