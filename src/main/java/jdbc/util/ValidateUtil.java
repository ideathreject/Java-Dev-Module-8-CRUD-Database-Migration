package jdbc.util;

public class ValidateUtil {
    private ValidateUtil() {}

    public static void validateName(String name) {
        if (name == null || name.length() < 3 || name.length() > 1000) {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    public static void validateId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }
}
