package java24Files;

import org.junit.jupiter.api.Test;

import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneBookTest {
    private final static String path = "C:\\Users\\yuliy\\IdeaProjects\\JavaCourse\\src\\java24Files\\phonebook.txt";
    PhoneBook phoneBook = new PhoneBookImpl(new File(path));
    @Test
    public void testGetNameByNumber() throws PhoneNumberNotFoundException {
        assertTrue(phoneBook.getNameByNumber(123).equals("Ivan"), "Not found");
    }

    @Test
    public void testGetNumberByName() {
        assertTrue(345 == phoneBook.getNumberByName("Petr"), "Not found");
    }
}
