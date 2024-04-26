package Base;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static List<String> username = new ArrayList<>();
    public static List<String> password = new ArrayList<>();

    // Getters and setters
    public static String getUsername(int index) {
        return username.get(index);

    }

    public static void setUsername(String username1) {
        username.add(username1);
    }

    public static String getPassword(int index) {
        return password.get(index);
    }

    public static void setPassword(String password1) {
        password.add(password1);
    }

}