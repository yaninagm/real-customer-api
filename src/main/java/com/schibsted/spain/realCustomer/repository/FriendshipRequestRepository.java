package com.schibsted.spain.realCustomer.repository;

import com.schibsted.spain.realCustomer.model.FriendshipRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRequestRepository extends JpaRepository<FriendshipRequest, Long> {

    @Query(value = "SELECT t FROM FriendshipRequest t where t.userFrom = :userFrom AND t.userTo = :userTo AND t.status = :status")
    public List<FriendshipRequest> findByUserFromAndUserToAndStatus(@Param("userFrom") String userFrom, @Param("userTo") String userTo, @Param("status")  String status);

    @Query(value = "SELECT t FROM FriendshipRequest t where t.status = :status AND (t.userFrom = :username OR t.userTo = :username)")
    public List<FriendshipRequest> findByUserFromOrUserToAndStatus(@Param("username") String username, @Param("status")  String status);

    @Query(value = "SELECT t FROM FriendshipRequest t where t.userFrom = :userFrom AND t.userTo = :userTo AND ( t.status = 'pending' OR  t.status = 'accepted') ")
    public List<FriendshipRequest> findByUserFromAndUserToInPendingOrAccepted(@Param("userFrom") String userFrom, @Param("userTo") String userTo);
}