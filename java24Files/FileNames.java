package java24Files;

import java.io.File;
import java.util.Objects;

public class FileNames {
    public static void main(String[] args) {
        try {
            File dir = new File("C:\\Users\\yuliy\\OneDrive\\Documents\\JAVA");
            //        Printing directories
            System.out.println("Directories are : ");
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                try {
                    if (file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
            //        Printing files
            System.out.println("Files are : ");
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                try {
                    String filename = file.getName();
                    if (filename.contains(".")) {
                        System.out.println(filename);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
