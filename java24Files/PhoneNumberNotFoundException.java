package java24Files;

public class PhoneNumberNotFoundException extends Exception {
    private String message;
    private int number;
    public PhoneNumberNotFoundException(String message) {
        super(message);
    }
}

