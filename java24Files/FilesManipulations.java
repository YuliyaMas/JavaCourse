package java24Files;

//Программно создать цепочку из трех папок.
//
//В конечном каталоге создать 5 произвольных текстовых файлов.
//
//Заполнить их 10 произвольными целыми числами.
//
//Содержимое файлов записать в один файл в том же каталоге.
//
//Создать файл, который будет содержать список файлов данного каталога.

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FilesManipulations {
    public static void main(String[] args) {
        String path = "C:\\Users\\yuliy\\IdeaProjects\\JavaCourse\\src\\java24Files\\";
//        Creating 3 folders (hierarchical way)
        for (int i = 1; i <= 3; i++) {
            File dir = new File(path + "folder" + i);
            dir.mkdir();
            path = String.valueOf(dir);
        }
//        In the last folder creating 5 files and writing chars (10 random int)
        for (int i = 1; i <= 5; i++) {
            File file = new File(path, "file" + i + ".txt");
            try {
                file.createNewFile();
                Random random = new Random();
                try (FileWriter fr = new FileWriter(file, true)) {
                    for (int index = 1; index <= 10; index++) {
                        int value = random.nextInt(100);
                        fr.write(String.valueOf(value));
                        fr.write(System.lineSeparator());
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
//        Reading txt files and writing the content in the new file in the same folder (summary file)
        File dir = new File(path);
        File newFile = new File(path, "groupFile.txt");
        File descriptionFile = new File(path, "descriptionFile.txt");
        for(File f: dir.listFiles()) {
            try (Scanner scanner = new Scanner(f, "UTF-8");
                 FileWriter fr = new FileWriter(newFile, true)){
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    fr.write(line.toCharArray());
                    fr.write(System.lineSeparator());
                    }
                } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            Writing the file's name in the description file in the same folder
            try (FileWriter fr = new FileWriter(descriptionFile, true)){
                fr.write(f.getName());
                fr.write(System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
