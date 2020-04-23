package com.schibsted.spain.friends.integration;

import com.schibsted.spain.friends.model.FriendshipRequest;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.FriendshipRequestRepository;
import com.schibsted.spain.friends.repository.UserRepository;
import com.schibsted.spain.friends.service.FriendshipService;
import com.schibsted.spain.friends.service.ValidationsService;
import com.schibsted.spain.friends.legacy.FriendshipLegacyController;
import com.schibsted.spain.friends.legacy.SignupLegacyController;
import com.schibsted.spain.friends.service.LoginService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FriendshipLegacyController.class)

@ContextConfiguration()
public class FriendshipListControllerTest {



    @TestConfiguration
    static class FriendshipLegacyControllerTestContextConfiguration {
        @Bean
        public FriendshipLegacyController friendshipLegacyController() {
            return new FriendshipLegacyController();
        }
    }
    @Autowired
    FriendshipLegacyController friendshipLegacyController;


    @TestConfiguration
    static class FriendshipServiceTestContextConfiguration {
        @Bean
        public FriendshipService friendshipService() {
            return new FriendshipService();
        }
    }

    @Autowired
    FriendshipService friendshipService;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserRepository userRepository;
    @MockBean
    FriendshipRequestRepository friendshipRequestRepository;
    @MockBean
    SignupLegacyController signupLegacyController;
    @MockBean
    ValidationsService validationsService;
    @MockBean
    LoginService loginService;

    @Test
    public void listFriends() throws Exception{
        // MOCK findByUserFromOrUserToAndStatus
        ArrayList<FriendshipRequest> friendshipRequests =  new ArrayList<>();
        Date date = new Date();
        FriendshipRequest friendshipRequest1 = new FriendshipRequest("Ruben", "Mario", "accepted", date, date);
        FriendshipRequest friendshipRequest2 = new FriendshipRequest("Mario", "Estefania", "accepted", date, date);
        FriendshipRequest friendshipRequest3 = new FriendshipRequest("Mario", "Sol", "declined", date, date);
        FriendshipRequest friendshipRequest4 = new FriendshipRequest("Gabriel", "Mario", "pending", date, date);
        friendshipRequests.add(friendshipRequest1);
        friendshipRequests.add(friendshipRequest2);
        friendshipRequests.add(friendshipRequest3);
        friendshipRequests.add(friendshipRequest4);
        Mockito.doReturn(friendshipRequests).when(friendshipRequestRepository).findByUserFromOrUserToAndStatus("Mario", "accepted");

        // MOCK findByUserName
        List<User> users = new ArrayList<>();
        User user = new User("Mario", "pass");
        users.add(user);
        Mockito.doReturn(users).when(userRepository).findByUserName("Mario");

        // EXECUTE
        MvcResult mvcResult = mockMvc.perform(
                get("/friendship/list")
                        .param("username", "Mario")
                        .header("X-Password", "pass")
        )
                .andExpect(status().isOk())
                .andReturn();

        // VALIDATE
        Assert.assertEquals("[\"Ruben\",\"Estefania\",\"Sol\",\"Gabriel\"]", mvcResult.getResponse().getContentAsString());
    }
}
