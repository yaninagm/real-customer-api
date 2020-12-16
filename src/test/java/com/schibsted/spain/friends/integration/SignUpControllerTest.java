package com.schibsted.spain.friends.integration;

import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.FriendshipRequestRepository;
import com.schibsted.spain.friends.repository.UserRepository;
import com.schibsted.spain.friends.service.FriendshipService;
import com.schibsted.spain.friends.service.ValidationsService;
import com.schibsted.spain.friends.controller.FriendshipLegacyController;
import com.schibsted.spain.friends.controller.SignupLegacyController;
import com.schibsted.spain.friends.service.LoginService;
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
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FriendshipLegacyController.class)

@ContextConfiguration()
public class SignUpControllerTest {



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


    @TestConfiguration
    static class SignupLegacyControllerTestContextConfiguration {
        @Bean
        public SignupLegacyController signupLegacyController() {
            return new SignupLegacyController();
        }
    }
    @Autowired
    SignupLegacyController signupLegacyController;

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
        User user = new User("MarioPeder", "pass123456");
        users.add(user);
        Mockito.doReturn(users).when(userRepository).findByUserName("MarioPeder");

        // MOCK findByUserFromAndUserToInPendingOrAccepted
        when(userRepository.save(any(User.class))).thenReturn(user);


        // ApiCall
       mockMvc.perform(
                post("/signup")
                        .param("username", "MarioPeder")
                        .header("X-Password", "pass123456")
        )
                .andExpect(status().isOk());
    }

}
