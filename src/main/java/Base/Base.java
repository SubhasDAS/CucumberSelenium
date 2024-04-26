package Base;

import java.util.Random;

public class Base {

    public static String generateRandomString(int length, String str) {
        String initial = str;
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        sb.append(initial);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

}
