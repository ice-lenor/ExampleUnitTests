package user_age;
import java.util.ArrayList;
import java.util.Arrays;

public class UsersDatabase {
    private ArrayList<User> users;

    public UsersDatabase() {
        users = new ArrayList<>(
            Arrays.asList(
                new User(1, "Emma", DateHelpers.parseDate("1983-12-03")),
                new User(2, "Janneke", DateHelpers.parseDate("1992-04-25")),
                new User(3, "Jaap", DateHelpers.parseDate("1996-02-19")),
                new User(4, "Sophie", DateHelpers.parseDate("1978-07-30")),
                new User(5, "Pieter", DateHelpers.parseDate("2019-01-01"))
            )
        );
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
