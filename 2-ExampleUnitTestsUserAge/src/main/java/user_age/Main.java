package user_age;

public class Main {
    public static void main(String[] args) {

        int userId = 5;

        UsersDatabase usersDatabase = new UsersDatabase();
        UserAgeCalculator calculator = new UserAgeCalculator(usersDatabase);

        System.out.print("User age = " + calculator.calculateUserAge(userId) + " days");
    }
}
