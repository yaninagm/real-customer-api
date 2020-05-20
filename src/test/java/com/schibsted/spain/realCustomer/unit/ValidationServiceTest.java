package com.schibsted.spain.realCustomer.unit;

import com.schibsted.spain.realCustomer.model.User;
import com.schibsted.spain.realCustomer.repository.UserRepository;
import com.schibsted.spain.realCustomer.service.ValidationsService;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ValidationServiceTest {

    @TestConfiguration
    static class ValidationServiceTestContextConfiguration {
        @Bean
        public ValidationsService validationsService() {
            return new ValidationsService();
        }
    }

    @Autowired
    ValidationsService validationsService;
    @MockBean
    UserRepository userRepository;
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void validateBadPasswordSmall() {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Password must be into 8 to 10 characters");
        validationsService.validatePassword("pass");
    }
    @Test
    public void validateBadPasswordAlphanumeric() {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Username and password must be alphanumeric");
        validationsService.validatePassword("2-22222");
    }

    @Test
    public void validateBadUserNameSmall() {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Username must be into 5 to 10 characters");
        validationsService.validateUserName("user");
    }
    @Test
    public void validateBadUserNameAlphanumeric() {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Username and password must be alphanumeric");
        validationsService.validateUserName("11.0-11");
    }

    @Test
    public void UserDoesntExits() {
        List<User> users = new ArrayList<>();
        User user = new User("Mario", "pass");
        users.add(user);
        Mockito.doReturn(users).when(userRepository).findByUserName("Alberto");

        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("User already exist");
        validationsService.validateIfUserExist("Alberto");
    }

}
