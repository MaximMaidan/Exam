package com.company;

// класс записи и чтения данных из файла

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MakeSerialize implements Serializable {

    //метод сохранения объекта в файл
    public static void saveToFile(Organization employees, String fName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(employees);
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }
    }

    // метод загрузки объекта из файла
    public static Organization loadFromFile(String fName) {
        Organization employees2 = null;
        try (FileInputStream fis = new FileInputStream(fName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            employees2 = (Organization) ois.readObject();

        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Deserialization exception: " + ex);
        }
        return employees2;
    }

}
