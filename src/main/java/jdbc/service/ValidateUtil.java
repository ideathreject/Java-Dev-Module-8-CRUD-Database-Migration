package jdbc.service;

class ValidateUtil {
    private ValidateUtil() {
    }

    static void validateName(String name) {
        if (name == null || name.length() < 3 || name.length() > 1000) {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    static void validateId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }
}
