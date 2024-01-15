package java24Files;

import java.io.*;
import java.util.Scanner;

public class ReadingFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\yuliy\\IdeaProjects\\JavaCourse\\src\\java24Files\\exercise2.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String text = "To create a file in Java, you can use the createNewFile() method. This method returns a boolean " +
                "value: true if the file was successfully created, and false if the file already exists. " +
                "Note that the method is enclosed in a try...catch block. This is necessary because it throws an " +
                "IOException if an error occurs (if the file cannot be created for some reason).";
        try (FileWriter fileWriter = new FileWriter(file, false);) {
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int punctuation = 0;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                System.out.println(line);
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '!' || line.charAt(i) == ',' || line.charAt(i) == ';' || line.charAt(i) == '.' || line.charAt(i) == '?' || line.charAt(i) == '-' ||
                            line.charAt(i) == '\'' || line.charAt(i) == '\"' || line.charAt(i) == ':' || line.charAt(i) == '(' || line.charAt(i) == ')') {
                        punctuation++;
                    }
                }
                System.out.println("The number of punctuation's symbols is " + punctuation);
                String[] words = line.split(" ");
                System.out.println("The number of words is " + words.length);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
