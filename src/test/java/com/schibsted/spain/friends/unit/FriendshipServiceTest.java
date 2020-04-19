package com.schibsted.spain.friends.unit;

import com.schibsted.spain.friends.config.Constants;
import com.schibsted.spain.friends.model.FriendshipRequest;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.FriendshipRequestRepository;
import com.schibsted.spain.friends.repository.UserRepository;
import com.schibsted.spain.friends.service.FriendshipService;
import com.schibsted.spain.friends.service.ValidationsService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class FriendshipServiceTest {

    @TestConfiguration
    static class ValidationServiceTestContextConfiguration {
        @Bean
        public ValidationsService validationsService() {
            return new ValidationsService();
        }
    }

    @Autowired
    FriendshipService friendshipService;
    @Autowired
    @MockBean
    FriendshipRequestRepository friendshipRequestRepository;
    @MockBean
    UserRepository userRepository;
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void requestFriendship() {

        ArrayList<FriendshipRequest> friendshipRequests =  new ArrayList<>();
        Date date = new Date();
        Mockito.doReturn(friendshipRequests).when(friendshipRequestRepository).findByUserFromAndUserToInPendingOrAccepted("Mario", "Estefania");

        FriendshipRequest friendshipRequest = new FriendshipRequest("Mario", "Estefania", Constants.STATUS_PENDING , date,  date);
        when(friendshipRequestRepository.save(any(FriendshipRequest.class))).thenReturn(friendshipRequest);

        FriendshipRequest response = friendshipService.requestFriendship("Mario", "Estefania");
        Assert.assertEquals(friendshipRequest.getUserFrom(), response.getUserFrom());
        Assert.assertEquals(friendshipRequest.getStatus(), "pending");
    }


    @Test
    public void requestFriendshipAlredyExist() {

        ArrayList<FriendshipRequest> friendshipRequests =  new ArrayList<>();
        Date date = new Date();
        FriendshipRequest friendshipRequest2 = new FriendshipRequest("Mario", "Estefania", "pending", date, date);
        friendshipRequests.add(friendshipRequest2);
        Mockito.doReturn(friendshipRequests).when(friendshipRequestRepository).findByUserFromAndUserToInPendingOrAccepted("Mario", "Estefania");


        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Request already exist");
        friendshipService.requestFriendship("Mario", "Estefania");
    }
}
