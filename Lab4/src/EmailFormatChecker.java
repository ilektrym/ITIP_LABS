import java.io.FileWriter;
import java.io.IOException;

public class EmailFormatChecker {
    public static void main(String[] args) {
        String[] emails = { "test@test", "invalid_email", "example@example.com", "example@mail.ru" };

        for (String email : emails) {
            try {
                checkEmailFormat(email);
            } catch (CustomEmailFormatException ex) {
                handleException(ex);
            }
        }
    }

    public static void checkEmailFormat(String email) throws CustomEmailFormatException {
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new CustomEmailFormatException("Не верный формат Email: " + email);
        }
    }

    public static void handleException(Exception ex) {
        try (FileWriter writer = new FileWriter("exceptions.log", true)) {
            writer.write(ex.getMessage() + "\n");
        } catch (IOException e) {
            System.err.println("Не удалось выполнить запись в файл exceptions.log");
        }
    }
}
class CustomEmailFormatException extends Exception {
    public CustomEmailFormatException(String message) {
        super(message);
    }
}