package user_age;

import org.junit.*;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.text.*;
import java.util.Date;

public class UserAgeCalculatorTest {

    private DateFormat dateParser = new SimpleDateFormat("yyyy-mm-dd");
    private int userId = 42;
    private UsersDatabase usersDatabase;
    private UserAgeCalculator calculator;

    @Before
    public void setup() {
        usersDatabase = Mockito.mock(UsersDatabase.class);
        calculator = new UserAgeCalculator(usersDatabase);
    }

    @Test
    public void userAge28Days() {

        User user = new User(userId, "Young child", parseDate("2019-01-01"));
        Mockito.when(usersDatabase.getUserById(userId)).thenReturn(user);

        int resultAge = calculator.calculateUserAge(userId);

        assertEquals(28, resultAge);
    }

    @Test
    public void userAge365Days() {

        User user = new User(userId, "Someone", parseDate("2018-01-29"));
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

        User user = new User(userId, "Someone", parseDate("2019-01-31"));
        Mockito.when(usersDatabase.getUserById(userId)).thenReturn(user);

        int resultAge = calculator.calculateUserAge(userId);

        assertEquals(-1, resultAge);
    }

    private Date parseDate(String date) {
        try {
            return dateParser.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}
