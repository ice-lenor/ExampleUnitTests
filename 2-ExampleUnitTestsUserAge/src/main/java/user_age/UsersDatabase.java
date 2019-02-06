package user_age;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class UsersDatabase {
    private ArrayList<User> users;

    public UsersDatabase() {

        users = new ArrayList<>();

        try {
            String filePath = new File("").getAbsolutePath();
            FileReader filereader = new FileReader(filePath.concat("/resources/users_database.csv"));
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                User user = new User(Integer.parseInt(row[0]), row[1], DateHelpers.parseDate(row[2]));
                users.add(user);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
