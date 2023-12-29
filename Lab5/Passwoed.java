import java.util.regex.*;

public class Passwoed {
    public static void main(String[] args) {
        String password = "Pass______0rd";
        Pattern passwordPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])[\\w]{8,16}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);

        if (passwordMatcher.matches()) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
        }
    }
}

