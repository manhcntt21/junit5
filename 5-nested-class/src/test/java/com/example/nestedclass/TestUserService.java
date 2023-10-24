package com.example.nestedclass;

import com.example.nestedclass.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author manhdt14
 * created in 10/24/2023 8:04 AM
 */
public class TestUserService {
    private UserService userService;

    @BeforeEach
    public void init() {
        userService = new UserService();
    }

    @Test
    public void logoutSuccess() {
        long userId = 1L;
        assertTrue(userService.logout(userId));

    }

    @Test
    public void resetPasswordExistingUser() {
        long userId = 1l;
        assertTrue(userService.resetPassword(userId));

    }

    @Test
    public void resetPasswordUserNotExist() {
        long userId = 5l;
        assertFalse(userService.resetPassword(userId));

    }

    @Nested
    @DisplayName("Test Login Feature")
    class LoginFeature {

        @Test
        void loginUsernamePasswordAreCorrect() {
            boolean actual = userService.login("admin", "password123");
            assertTrue(actual);
        }

        @Test
        void loginUsernamePasswordAreInCorrect() {
            boolean actual = userService.login("admin", "password123456");
            assertFalse(actual);
        }

        @Test
        void loginUsernamePasswordAreNulls() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                userService.login(null, null);
            });
            assertEquals("Username and password must not be null or empty", exception.getMessage());

        }

        @Test
        void loginUsernamePasswordAreEmpty() {

            assertThrows(IllegalArgumentException.class, () -> {
                userService.login("", "");
            });

        }
    }
}
