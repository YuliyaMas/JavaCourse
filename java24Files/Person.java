package java24Files;

import java.io.*;

public class Person {
    final static String path = "C:\\Users\\yuliy\\IdeaProjects\\JavaCourse\\src\\java24Files\\";
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(path + "exercise4.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fr = new FileWriter(file, true)) {
        for (int i = 1; i <= 10; i++) {
            Person person = new Person("Harris" + i, "John" + i, 20 + i * 2);
                String data = person.name + " " + person.surname + ", " + person.age;
                fr.write(data);
                fr.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
