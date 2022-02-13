package willing;

import zoo.Zoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForWillingApplication {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        Zoo zoo = configuration.createInitialZooKrakow();

        String path = "src/main/resources/animals.txt";
        File file = new File(path);
        List<String> fileBody = new ArrayList<>();
        FileWriter fileWriter = null;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            fileBody = bufferedReader.lines().map(animal -> animal + "\n").collect(Collectors.toList());
            fileWriter = new FileWriter(path);

        } catch (IOException e) {
            System.out.println("File not exist. Now one has been created");
            try {
                fileWriter = new FileWriter(path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } finally {
            convertAnimalsToTxt(zoo, fileBody, fileWriter);
        }


        // using append eliminates the needs to use FileReader
        //try {
        //    FileWriter fileWriter = new FileWriter(file, true);
        //    convertAnimalsToTxt(zoo, fileWriter);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }

    // using append eliminates the needs to use FileReader
    public static void convertAnimalsToTxt(Zoo zoo, FileWriter fileWriter) {
        zoo.getAnimals()
                .forEach(animal -> {
                    try {
                        fileWriter.write(animal.getName() + "\n");
                    } catch (IOException e) {
                        System.out.println("Cant write to file");
                    }
                });

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cant close file");
        }
    }

    public static void convertAnimalsToTxt(Zoo zoo, List<String> fileBody, FileWriter fileWriter) {
        zoo.getAnimals()
                .stream()
                .map(animal -> animal.getName() + "\n")
                .forEach(fileBody::add);

        try {
            for (String s : fileBody) {
                fileWriter.write(s);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cant close file");
        }
    }
}
