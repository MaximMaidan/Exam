package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Organization implements Serializable {

    public ArrayList<Employee> employees = new ArrayList<>();

    // прием на работу сотрудника
    public void employment(String surname, String name, String patronymic,
                           LocalDate birthDate, String gender, String telNumber,
                           String post, String department, String chief,
                           LocalDate employmentDate, Double salary) {
        employees.add(new Employee(surname, name, patronymic,
                birthDate, gender, telNumber,
                post, department, chief,
                employmentDate, salary));
    }

    // увольнение сотрудника
    public void dismissal(String surname, String name, String department) {
        employees.removeIf(x -> Objects.equals(x.surname, surname)
                && Objects.equals(x.name, name) &&
                (Objects.equals(x.department, department)));
    }

    // изменение информации о сотруднике
    public void changeEmployee(String surname, String name, String department) {
        Employee emp = employees.stream()
                .filter(x -> Objects.equals(x.surname, surname)
                && Objects.equals(x.name, name) &&
                (Objects.equals(x.department, department)))
                .findFirst()
                .get();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер поля, которое хотите изменить: ");
        System.out.println("1. Фамилия");
        System.out.println("2. Имя");
        System.out.println("3. Отчество");
        System.out.println("4. Дата рождения");
        System.out.println("5. Пол");
        System.out.println("6. Контактный номер телефона");
        System.out.println("7. Должность");
        System.out.println("8. Наименование отдела");
        System.out.println("9. ФИО Руководителя");
        System.out.println("10. Дата приема на работу");
        System.out.println("11. Зарплата");
        int reply = sc.nextInt();
        switch (reply) {
            case(1)-> {
                System.out.println("Текущее значение " + emp.getSurname());
                System.out.println("Введите новое значение");
                emp.setSurname(sc.nextLine());
            }
            case(2)-> {
                System.out.println("Текущее значение " + emp.getName());
                System.out.println("Введите новое значение");
                emp.setName(sc.nextLine());
            }
            case(3)-> {
                System.out.println("Текущее значение " + emp.getPatronymic());
                System.out.println("Введите новое значение");
                emp.setPatronymic(sc.nextLine());
            }
            case(4)-> {
                System.out.println("Текущее значение " + emp.getBirthDate());
                System.out.println("Введите новое значение");
                emp.setBirthDate(LocalDate.parse(sc.nextLine()));
            }
            case(5)-> {
                System.out.println("Текущее значение " + emp.getGender());
                System.out.println("Введите новое значение");
                emp.setGender(sc.nextLine());
            }
            case(6)-> {
                System.out.println("Текущее значение " + emp.getTelNumber());
                System.out.println("Введите новое значение");
                emp.setTelNumber(sc.nextLine());
            }
            case(7)-> {
                System.out.println("Текущее значение " + emp.getPost());
                System.out.println("Введите новое значение");
                emp.setPost(sc.nextLine());
            }
            case(8)-> {
                System.out.println("Текущее значение " + emp.getDepartment());
                System.out.println("Введите новое значение");
                emp.setDepartment(sc.nextLine());
            }
            case(9)-> {
                System.out.println("Текущее значение " + emp.getChief());
                System.out.println("Введите новое значение");
                emp.setChief(sc.nextLine());
            }
            case(10)-> {
                System.out.println("Текущее значение " + emp.getEmploymentDate());
                System.out.println("Введите новое значение");
                emp.setEmploymentDate(LocalDate.parse(sc.nextLine()));
            }
            case(11)-> {
                System.out.println("Текущее значение " + emp.getSalary());
                System.out.println("Введите новое значение");
                emp.setSalary(sc.nextDouble());
            }
        }
    }

    // поиск сотрудника внутри организации

    // поиск по фамилии
    public java.util.List<Employee> surnameFind(String surname) {
        return employees.stream()
                .filter(s -> Objects.equals(s.getSurname(), surname))
                .toList();
    }

    // поиск по имени
    public java.util.List<Employee> nameFind(String name) {
        return employees.stream()
                .filter(s -> Objects.equals(s.getName(), name))
                .toList();
    }

    // поиск по отчеству
    public java.util.List<Employee> patronymicFind(String patronymic) {
        return employees.stream()
                .filter(s -> Objects.equals(s.getPatronymic(), patronymic))
                .toList();
    }

    // поиск по должности
    public java.util.List<Employee> postFind(String post) {
        return employees.stream()
                .filter(s -> Objects.equals(s.getPost(), post))
                .toList();
    }

    // поиск по наименованию отдела
    public java.util.List<Employee> departmentFind(String department) {
        return employees.stream()
                .filter(s -> Objects.equals(s.getDepartment(), department))
                .toList();
    }

    // поиск по руководителю
    public java.util.List<Employee> chiefFind(String chief) {
        return employees.stream()
                .filter(s -> Objects.equals(s.getChief(), chief))
                .toList();
    }

    // отчеты об организации

    // информация об отделах, ФИО начальников
    public List<String> orgInfo() {
        return employees.stream()
                .map(x -> "Отдел " + x.department + " - Руководитель " + x.chief)
                .distinct()
                .toList();

    }

    // средняя зарплата по организации
    public double averageSalaryByOrg() {
        double salarySum = (int) employees.stream()
                .mapToDouble(Employee::getSalary)
                .reduce(0, Double::sum);
        int employeeCount = employees.size();
        return  (salarySum / employeeCount);
    }

    // средняя зарплата по отделу
    public double averageSalaryByDep(String department) {
        double salarySumDep = (int) employees.stream()
                .filter(x -> Objects.equals(x.department, department))
                .mapToDouble(Employee::getSalary)
                .reduce(0, Double::sum);
        int employeeCountDep = (int) employees.stream()
                .filter(x -> Objects.equals(x.department, department))
                .count();
        return salarySumDep / employeeCountDep;
    }

    // ТОП-10 самых высокооплачиваемых сотрудников
    public java.util.List<Employee> expensiveEmp() {
        return employees.stream()
                .sorted(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        if (Objects.equals(o1.salary, o2.salary))
                            return o1.salary.compareTo(o2.salary);
                        else
                            return o2.salary.compareTo(o1.salary);
                    }

                })
                .limit(10)
                .toList();
    }

    // ТОП-10 самых преданных сотрудников (по количеству лет работы в организации)
    public List<Employee> loyalEmp() {
        return employees.stream()
                .sorted(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        if (Objects.equals(o1.employmentDate, o2.employmentDate))
                            return o2.employmentDate.compareTo(o1.employmentDate);
                        else
                            return o1.employmentDate.compareTo(o2.employmentDate);
                    }

                })
                .limit(10)
                .toList();
    }

    // список всех сотрудников
    public List<Employee> allEmp() {
        return employees.stream()
                .toList();
    }

    // вывод на консоль отчета поиска по фамилии
    public void surnameFindIn(String surname) {
        surnameFind(surname).forEach(System.out::println);
    }

    // вывод на консоль отчета поиска по имени
    public void nameFindIn(String name) {
        nameFind(name).forEach(System.out::println);
    }

    // вывод на консоль отчета поиска по отчеству
    public void patronymicFindIn(String patronymic) {
        patronymicFind(patronymic).forEach(System.out::println);
    }

    // вывод на консоль отчета поиска по должности
    public void postFindIn(String post) {
        postFind(post).forEach(System.out::println);
    }

    // вывод на консоль отчета поиска по наименованию отдела
    public void departmentFindIn(String department) {
        departmentFind(department).forEach(System.out::println);
    }

    // вывод на консоль отчета поиска по руководителю
    public void chiefFindIn(String chief) {
        chiefFind(chief).forEach(System.out::println);
    }

    // вывод на консоль информации об отделах, ФИО начальников
    public void orgInfoIn() {
        System.out.println("Информация об отделах, ФИО начальников");
        orgInfo().forEach(System.out::println);
    }

    // вывод на консоль средней зарплаты по организации
    public void averageSalaryByOrgIn() {
        System.out.printf("Средняя зарплата по организации %.2f", averageSalaryByOrg());
        System.out.println();
    }

    // вывод на консоль средней зарплаты по отделу
    public void averageSalaryByDepIn(String department) {
        System.out.printf("Средняя зарплата по департаменту "
                + department + " %.2f", averageSalaryByDep(department));
        System.out.println();
    }

    // вывод на консоль ТОП-10 самых высокооплачиваемых сотрудников
    public void expensiveEmpIn() {
        System.out.println("ТОП-10 самых высокооплачиваемых сотрудников");
        expensiveEmp().forEach(System.out::println);
    }

    // вывод на консоль ТОП-10 самых преданных сотрудников
    public void loyalEmpIn() {
        System.out.println("ТОП-10 самых преданных сотрудников");
        loyalEmp().forEach(System.out::println);
    }

    // вывод на консоль списка всех сотрудников
    public void allEmpIn() {
        System.out.println("Сотрудники организации");
        allEmp().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return employees.toString();
    }

}
