package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class InputFile implements Serializable {

    // запись символьного отчета в файл

    public static <T> void reportOutput(List<T> str, String fname) throws IOException {
        try (FileWriter fw = new FileWriter(fname);
             BufferedWriter bw = new BufferedWriter(fw)) {
            str.forEach((employee) -> {
                try {
                    bw.write(employee.toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    // запись double в файл
    public static void numReportOutput(double num, String fname) throws IOException {
        try (FileWriter fw = new FileWriter(fname);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(String.format("%.2f", num));
        }
    }
}
