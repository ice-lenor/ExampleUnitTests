package user_age;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserAgeCalculatorTest1 {

    @Test
    public void userAge28Days() {

        UsersDatabase usersDatabase = new UsersDatabase();
        UserAgeCalculator calculator = new UserAgeCalculator(usersDatabase);

        int resultAge = calculator.calculateUserAge(1);

        assertEquals(12850, resultAge);
    }
}