package user_age;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class UsersDatabase {
    private ArrayList<User> users;

    public UsersDatabase() {
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        try {
            users = new ArrayList<>(
                Arrays.asList(
                    new User(1, "Emma", formatter.parse("1983-12-03")),
                    new User(2, "Janneke", formatter.parse("1992-04-25")),
                    new User(3, "Jaap", formatter.parse("1996-02-19")),
                    new User(4, "Sophie", formatter.parse("1978-07-30")),
                    new User(5, "Pieter", formatter.parse("2019-01-01"))
                )
            );
        } catch (ParseException e) {

        };
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
