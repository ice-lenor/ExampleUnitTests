package user_age;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import java.util.Date;

public class UserAgeCalculatorTest3 {

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
    public void userBabyAge() {

        User user = new User(userId, "Young child", DateHelpers.parseDate("2019-01-01"));

        Mockito.when(usersDatabase.getUserById(userId)).thenReturn(user);

        int resultAge = calculator.calculateUserAge(userId);

        assertEquals(56, resultAge);
    }

    @Test
    public void userAge365Days() {

        User user = new User(userId, "Someone", DateHelpers.parseDate("2018-02-26"));
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

        User user = new User(userId, "Someone", DateHelpers.parseDate("2019-02-27"));
        Mockito.when(usersDatabase.getUserById(userId)).thenReturn(user);

        int resultAge = calculator.calculateUserAge(userId);

        assertEquals(-1, resultAge);
    }

}
