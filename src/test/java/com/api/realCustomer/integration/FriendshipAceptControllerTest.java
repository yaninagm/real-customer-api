package com.api.realCustomer.integration;

import com.api.realCustomer.config.Constants;
import com.api.realCustomer.controller.FriendshipLegacyController;
import com.api.realCustomer.model.FriendshipRequest;
import com.api.realCustomer.model.User;
import com.api.realCustomer.repository.FriendshipRequestRepository;
import com.api.realCustomer.repository.UserRepository;
import com.api.realCustomer.service.FriendshipService;
import com.api.realCustomer.service.LoginService;
import com.api.realCustomer.service.ValidationsService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FriendshipLegacyController.class)

@ContextConfiguration()
public class FriendshipAceptControllerTest {

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
    static class LoginServiceTestContextConfiguration {
        @Bean
        public LoginService loginService() {
            return new LoginService();
        }
    }
    @Autowired
    @MockBean
    LoginService loginService;


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
    ValidationsService validationsService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void requestFriendshipOk() throws Exception{

        // MOCK findByUserName
        List<User> users = new ArrayList<>();
        User user = new User("Mario", "pass123456");
        users.add(user);
        Mockito.doReturn(users).when(userRepository).findByUserName("Mario");

        when(loginService.securePass("pass123456")).thenReturn("pass123456");

        Date date = new Date();
        // MOCK findByUserFromAndUserToInPendingOrAccepted
        ArrayList<FriendshipRequest> friendshipRequests =  new ArrayList<>();
        FriendshipRequest friendshipRequest2 = new FriendshipRequest("Mario", "Estefania", "pending", date, date);
        friendshipRequests.add(friendshipRequest2);
        Mockito.doReturn(friendshipRequests).when(friendshipRequestRepository).findByUserFromAndUserToAndStatus("Estefania", "Mario", Constants.STATUS_PENDING);

        FriendshipRequest friendshipRequest = new FriendshipRequest("Mario", "Estefania", Constants.STATUS_ACCEPTED , date,  date);
        when(friendshipRequestRepository.save(any(FriendshipRequest.class))).thenReturn(friendshipRequest);

        // ApiCall
        mockMvc.perform(
                post("/friendship/accept")
                        .param("usernameFrom", "Mario")
                        .param("usernameTo", "Estefania")
                        .header("X-Password", "pass123456")
        )
                .andExpect(status().isOk());
    }

    @Test
    public void requestFriendshipPending() throws Exception{

        // MOCK findByUserName
        List<User> users = new ArrayList<>();
        User user = new User("Mario", "pass123456");
        users.add(user);
        Mockito.doReturn(users).when(userRepository).findByUserName("Mario");
        when(loginService.securePass("pass123456")).thenReturn("pass123456");

        Date date = new Date();
        // MOCK findByUserFromAndUserToInPendingOrAccepted
        ArrayList<FriendshipRequest> friendshipRequests =  new ArrayList<>();
        Mockito.doReturn(friendshipRequests).when(friendshipRequestRepository).findByUserFromAndUserToAndStatus("Estefania", "Mario", Constants.STATUS_PENDING);

        FriendshipRequest friendshipRequest = new FriendshipRequest("Mario", "Estefania", Constants.STATUS_ACCEPTED , date,  date);
        when(friendshipRequestRepository.save(any(FriendshipRequest.class))).thenReturn(friendshipRequest);

        // ApiCall
        mockMvc.perform(
                post("/friendship/accept")
                        .param("usernameFrom", "Mario")
                        .param("usernameTo", "Estefania")
                        .header("X-Password", "pass123456")
        )
                .andExpect(status().is4xxClientError());
    }

}
