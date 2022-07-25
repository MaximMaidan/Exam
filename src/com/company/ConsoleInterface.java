package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

import static com.company.InputFile.numReportOutput;
import static com.company.InputFile.reportOutput;
import static com.company.MakeSerialize.loadFromFile;
import static com.company.MakeSerialize.saveToFile;


public class ConsoleInterface implements Serializable {

    // интерфейс работы программы
    public static void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите логин ");
        String login = sc.nextLine();
        System.out.println("Введите пароль ");
        String password = sc.nextLine();

        if (login.equals("123") && password.equals("qwe")) {
            boolean isEnd = false;
            Organization employees = loadFromFile("emp.txt");

            // цикл работы
            while (!isEnd) {
                System.out.println("Выберете действие:");
                System.out.println("1. Принять на работу сотрудника");
                System.out.println("2. Уволить сотрудника");
                System.out.println("3. Изменить информацию о сотруднике");
                System.out.println("4. Поиск сотрудника по фамилии");
                System.out.println("5. Поиск сотрудника по имени");
                System.out.println("6. Поиск сотрудника по отчеству");
                System.out.println("7. Поиск сотрудника по должности");
                System.out.println("8. Поиск сотрудника по наименованию отдела");
                System.out.println("9. Поиск сотрудника по руководителю");
                System.out.println("10. Получить информацию от отделах, ФИО начальников");
                System.out.println("11. Получить среднюю зарплату по организации");
                System.out.println("12. Получить среднюю зарплату по выбранному отделу");
                System.out.println("13. Получить список самых высокооплачиваемых сотрудников");
                System.out.println("14. Получить список самых преданных сотрудников");
                System.out.println("15. Получить список всех сотрудников организации");
                System.out.println("16. Выход из программы.");
                int reply;
                reply = sc.nextInt();
                int resultOutput;
                String fname;

                // прием сотрудника
                if (reply == 1) {
                    System.out.println("Введите Фамилию");
                    sc.nextLine();
                    String surname = sc.nextLine();
                    System.out.println("Введите имя");
                    String name = sc.nextLine();
                    System.out.println("Введите отчество");
                    String patronymic = sc.nextLine();
                    System.out.println("Введите дату рождения");
                    LocalDate birthDate = LocalDate.ofEpochDay(sc.nextInt());
                    System.out.println("Введите пол");
                    sc.nextLine();
                    String gender = sc.nextLine();
                    System.out.println("Введите контактный номер телефона");
                    String telNumber = sc.nextLine();
                    System.out.println("Введите должность");
                    String post = sc.nextLine();
                    System.out.println("Введите наименование отдела");
                    String department = sc.nextLine();
                    System.out.println("Введите ФИО руководителя");
                    String chief = sc.nextLine();
                    System.out.println("Введите дату приема на работу");
                    LocalDate employmentDate = LocalDate.ofEpochDay(sc.nextInt());
                    System.out.println("Введите заработную плату");
                    sc.nextLine();
                    double salary = sc.nextDouble();
                    employees.employment(surname, name, patronymic,
                            birthDate, gender, telNumber,
                            post, department, chief,
                            employmentDate, salary);
                    saveToFile(employees, "emp.txt");
                    System.out.println("Сотрудник добавлен в базу");
                }

                // увольнение сотрудника
                else if (reply == 2) {
                    System.out.println("Введите Фамилию");
                    sc.nextLine();
                    String surname = sc.nextLine();
                    System.out.println("Введите имя");
                    String name = sc.nextLine();
                    System.out.println("Введите наименование отдела");
                    String department = sc.nextLine();
                    employees.dismissal(surname, name, department);
                    saveToFile(employees, "emp.txt");
                    System.out.println("Сотрудник удален из базы");
                }

                // изменение информации о сотруднике
                else if (reply == 3){
                    System.out.println("Введите Фамилию");
                    sc.nextLine();
                    String surname = sc.nextLine();
                    System.out.println("Введите имя");
                    String name = sc.nextLine();
                    System.out.println("Введите наименование отдела");
                    String department = sc.nextLine();
                    employees.changeEmployee(surname, name, department);
                    saveToFile(employees, "emp.txt");
                    System.out.println("Информация о сотруднике в базе изменена");
                }

                // поиск по фамилии
                else if (reply == 4) {
                    System.out.println("Введите Фамилию");
                    sc.nextLine();
                    String surname = sc.nextLine();
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.surnameFindIn(surname);
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            reportOutput(employees.surnameFind(surname), fname);
                            System.out.println("Файл успешно записан");
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + resultOutput);
                    }
                }

                // поиск по имени
                else if (reply == 5) {
                    System.out.println("Введите Имя");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.nameFindIn(name);
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            reportOutput(employees.nameFind(name), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // поиск по отчеству
                else if (reply == 6) {
                    System.out.println("Введите Отчество");
                    sc.nextLine();
                    String patronymic = sc.nextLine();
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.patronymicFindIn(patronymic);
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            reportOutput(employees.patronymicFind(patronymic), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // поиск по должности
                else if (reply == 7) {
                    System.out.println("Введите Должность");
                    sc.nextLine();
                    String post = sc.nextLine();
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.postFindIn(post);
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            reportOutput(employees.postFind(post), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // поиск по наименованию отдела
                else if (reply == 8) {
                    System.out.println("Введите Наименование отдела");
                    sc.nextLine();
                    String department = sc.nextLine();
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.departmentFindIn(department);
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            reportOutput(employees.departmentFind(department), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // поиск по руководителю
                else if (reply == 9) {
                    System.out.println("Введите ФИО Руководителя");
                    sc.nextLine();
                    String chief = sc.nextLine();
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.chiefFindIn(chief);
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            reportOutput(employees.chiefFind(chief), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // информация об отделах, ФИО начальников
                else if (reply == 10) {
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.orgInfoIn();
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            reportOutput(employees.orgInfo(), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // средняя зарплата по организации
                else if (reply == 11) {
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.averageSalaryByOrgIn();
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            numReportOutput(employees.averageSalaryByOrg(), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // средняя зарплата по отделу
                else if (reply == 12) {
                    System.out.println("Введите наименование отдела");
                    sc.nextLine();
                    String department = sc.nextLine();
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.averageSalaryByDepIn(department);
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            numReportOutput(employees.averageSalaryByDep(department), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // ТОП-10 самых высокооплачиваемых сотрудников
                else if (reply == 13) {
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.expensiveEmpIn();
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            reportOutput(employees.expensiveEmp(), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // ТОП-10 самых преданных сотрудников
                else if (reply == 14) {
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.loyalEmpIn();
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            reportOutput(employees.loyalEmp(), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // Список всех сотрудников
                else if (reply == 15) {
                    System.out.println("Выберете действие:");
                    System.out.println("1. Вывести на консоль");
                    System.out.println("2. Записать в файл");
                    resultOutput = sc.nextInt();
                    switch (resultOutput) {
                        case (1) -> employees.allEmpIn();
                        case (2) -> {
                            System.out.println("Введите название файла");
                            sc.nextLine();
                            fname = sc.nextLine();
                            reportOutput(employees.allEmp(), fname);
                            System.out.println("Файл успешно записан");
                        }
                    }
                }

                // завершение работы
                else if (reply == 16) {
                    System.out.println("До свидания...");
                    isEnd = true;
                }
            }
        } else
            System.out.println("Логин или Пароль Введены некорректно");
        sc.close();
    }




}
