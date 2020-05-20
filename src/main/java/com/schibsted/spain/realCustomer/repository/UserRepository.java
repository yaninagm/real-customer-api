package com.schibsted.spain.realCustomer.repository;


import com.schibsted.spain.realCustomer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByUserName(String username);

}