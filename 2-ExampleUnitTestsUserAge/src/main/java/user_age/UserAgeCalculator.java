package user_age;

import java.util.Date;

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
        now.setHours(0);
        now.setMinutes(0);
        now.setSeconds(0);
        long daysNow = now.getTime() / 1000 / 60 / 60 / 24;
        long daysUser = user.getBirthDate().getTime() / 1000 / 60 / 60 / 24;
        return (int)(daysNow - daysUser);
    }
}
