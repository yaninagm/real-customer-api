package com.schibsted.spain.realCustomer.service;

import com.schibsted.spain.realCustomer.config.Constants;
import com.schibsted.spain.realCustomer.model.FriendshipRequest;
import com.schibsted.spain.realCustomer.repository.FriendshipRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.*;

@Service
public class FriendshipService {
    @Autowired
    FriendshipRequestRepository friendshipRequestRepository;

    public FriendshipRequest requestFriendship(String usernameFrom, String usernameTo){
        List<FriendshipRequest> relation = friendshipRequestRepository.findByUserFromAndUserToInPendingOrAccepted(usernameFrom, usernameTo);
        if(!relation.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request already exist");
        Date newDate = new Date();
        FriendshipRequest friendshipRequest = new FriendshipRequest(usernameFrom, usernameTo, Constants.STATUS_PENDING , newDate,  newDate);
        friendshipRequestRepository.save(friendshipRequest);
        return friendshipRequest;
    }

    public FriendshipRequest changeStatusFriendshipRequest(String usernameFrom, String usernameTo, String newStatus) {
        List<FriendshipRequest> relations = friendshipRequestRepository.findByUserFromAndUserToAndStatus(usernameTo, usernameFrom, Constants.STATUS_PENDING);
        if (relations.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You haven't any request");
        FriendshipRequest friendshipRequest = relations.iterator().next();
        friendshipRequest.setStatus(newStatus);
        friendshipRequest.setDateLastModified(new Date());
        friendshipRequestRepository.save(friendshipRequest);
        return friendshipRequest;
    }

    public ArrayList <String> getAcceptFriendshipRequest(String username){
        List<FriendshipRequest> friendshipRequests = friendshipRequestRepository.findByUserFromOrUserToAndStatus(username, Constants.STATUS_ACCEPTED);
        ArrayList <String> friends = new ArrayList<>();
        for (FriendshipRequest friendshipRequest : friendshipRequests) {
            if (friendshipRequest.getUserTo().equals(username)) {
                friends.add(friendshipRequest.getUserFrom());
            }else {
                friends.add(friendshipRequest.getUserTo());
            }
        }
        return friends;
    }

}
