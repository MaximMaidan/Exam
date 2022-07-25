package com.company;

import java.io.IOException;
import java.time.LocalDate;


import static com.company.ConsoleInterface.run;
import static com.company.FirstTimeBaseGen.genBase;
import static com.company.InputFile.reportOutput;
import static com.company.MakeSerialize.loadFromFile;
import static com.company.MakeSerialize.saveToFile;


public class Main {

    public static void main(String[] args) throws IOException {
        // формирование базы данных
        //saveToFile(genBase(), "emp.txt");

        // запуск программы. Логин "123", пароль "qwe"
        run();
    }
}