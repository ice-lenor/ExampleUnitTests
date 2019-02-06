package user_age;

import org.junit.*;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class UserAgeCalculatorTest2 {

    private int userId = 42;
    private UsersDatabase usersDatabase;
    private UserAgeCalculator calculator;

    @Before
    public void setup() {
        usersDatabase = Mockito.mock(UsersDatabase.class);
        calculator = new UserAgeCalculator(usersDatabase);
    }

    @After
    public void teardown() {
        usersDatabase = null;
        calculator = null;
    }

    @Test
    public void userAge28Days() {

        User user = new User(userId, "Young child", DateHelpers.parseDate("2019-01-01"));
        Mockito.when(usersDatabase.getUserById(userId)).thenReturn(user);

        int resultAge = calculator.calculateUserAge(userId);

        // check the call to the mock

        assertEquals(36, resultAge);
    }

    @Test
    public void userAge365Days() {

        User user = new User(userId, "Someone", DateHelpers.parseDate("2018-02-06"));
        Mockito.when(usersDatabase.getUserById(userId)).thenReturn(user);

        int resultAge = calculator.calculateUserAge(userId);

        assertEquals(365, resultAge);
    }

    @Test
    public void userIsNull() {

        User user = null;
        Mockito.when(usersDatabase.getUserById(userId)).thenReturn(user);

        assertThrows(IllegalArgumentException.class, () -> {
            int resultAge = calculator.calculateUserAge(userId);
        });
    }

    @Test
    public void userIsFromTheFuture() {

        User user = new User(userId, "Someone", DateHelpers.parseDate("2019-02-08"));
        Mockito.when(usersDatabase.getUserById(userId)).thenReturn(user);

        int resultAge = calculator.calculateUserAge(userId);

        assertEquals(-1, resultAge);
    }

}
