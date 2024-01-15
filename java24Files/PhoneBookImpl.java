package java24Files;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookImpl implements PhoneBook {
    private final File phoneBookFile;
    private final static String path = "C:\\Users\\yuliy\\IdeaProjects\\JavaCourse\\src\\java24Files\\phonebook.txt";
    private final List<String> users = new ArrayList<>();

    public PhoneBookImpl(File phoneBookFile) {
        this.phoneBookFile = phoneBookFile;
    }


    @Override
    public void addUser(String name, int number, LocalDate createdDate) {
        createdDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        String userData = name + ", " + number + " " + createdDate.format(formatter);
        users.add(userData);
    }


    @Override
    public int getNumberByName(String name) {
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(name)) {
                    data = data[1].trim().split(" ");
                    int phoneNumber = Integer.parseInt(data[0]);
                    System.out.println("The phone number of " + name + " is " + phoneNumber);
                    return phoneNumber;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file " + e.getMessage());
        }
        System.out.println("The name " + name + " is not found");
        return -1;
    }


    @Override
    public String getNameByNumber(int number) throws PhoneNumberNotFoundException {
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String[] phoneNumber = data[1].trim().split(" ");
                if (Integer.parseInt(phoneNumber[0]) == number) {
                    String name = data[0].trim();
                    System.out.println("The phone number " + number + " belongs to " + name);
                    return name;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file " + e.getMessage());
        }
        throw new PhoneNumberNotFoundException("It is not possible to find in the phonebook the number " + number);
    }

    @Override
    public void storeToFile(File phoneBookFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(phoneBookFile, false))) {
            for (String user : users) {
                bw.write(user + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile(File phoneBookFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(phoneBookFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(line);
            }
            System.out.println(users);
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file " + e.getMessage());
        }
    }

    public static void main(String[] args) throws PhoneNumberNotFoundException {
        File phoneBookFile = new File(path);
        PhoneBook phoneBook = new PhoneBookImpl(phoneBookFile);
        phoneBook.addUser("Ivan", 123, LocalDate.now());
        phoneBook.addUser("Petr", 345, LocalDate.now());
        phoneBook.storeToFile(new File(path));
        PhoneBook phoneBook2 = new PhoneBookImpl(phoneBookFile);
        phoneBook2.loadFromFile(new File(path));
        boolean userName = phoneBook.getNameByNumber(124).equals("Ivan");
        boolean userPhoneNumber = phoneBook.getNumberByName("Petr") == 345;
    }
}
