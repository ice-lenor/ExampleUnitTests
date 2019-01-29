package user_age;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UserAgeCalculator {
    private final UsersDatabase usersDatabase;

    public UserAgeCalculator(UsersDatabase usersDatabase) {
        this.usersDatabase = usersDatabase;
    }

    public int calculateUserAge(int userId) {

        User user = usersDatabase.getUserById(userId);
        if (user == null)
            throw new IllegalArgumentException("User doesn't exist");

        Date now = new Date();
        long diffInMilliseconds = now.getTime() - user.getBirthDate().getTime();
        return (int)TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
    }
}
