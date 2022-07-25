package com.company;

import java.io.Serializable;
import java.time.LocalDate;

public class FirstTimeBaseGen implements Serializable {

    public static Organization genBase()  {
        Organization employees = new Organization();

        employees.employment("Петров", "Игорь", "Алексеевич",
                LocalDate.of(1990, 12, 1), "муж", "2435676", "инженер",
                "ПТО", "Новиков Сергей Павлович",
                LocalDate.of(2007, 7, 15), 35000.0);
        employees.employment("Сидоров", "Игорь", "Иванович",
                LocalDate.of(1989, 9, 3), "муж", "2435677",
                "старший инженер", "ПТО", "Новиков Сергей Павлович",
                LocalDate.of(2005, 5, 17), 50000.0);
        employees.employment("Иванов", "Петр", "Константинович",
                LocalDate.of(1988, 7, 8), "муж", "2435678",
                "ведущий инженер", "ПТО", "Новиков Сергей Павлович",
                LocalDate.of(2003, 4, 12), 75000.0);
        employees.employment("Ковалев", "Сергей", "Сергеевич",
                LocalDate.of(1990, 12, 3), "муж", "2435278",
                "маркетолог", "Маркетинг", "Свиридова Ирина Константиновна",
                LocalDate.of(2008, 12, 6), 49000.0);
        employees.employment("Константинов", "Николай", "Михайлович",
                LocalDate.of(1990, 2, 23), "муж", "2435658",
                "старший маректолог", "Маркетинг", "Свиридова Ирина Константиновна",
                LocalDate.of(2006, 12, 8), 51000.0);
        employees.employment("Никаноров", "Андрей", "Викторович",
                LocalDate.of(1991, 1, 15), "муж", "2435668",
                "ведущий маркетолог", "Маркетинг", "Свиридова Ирина Константиновна",
                LocalDate.of(2004, 5, 19), 55000.0);
        employees.employment("Петров", "Аркадий", "Алексеевич",
                LocalDate.of(1972, 5, 5), "муж", "2435638",
                "завхоз", "АХО", "Фролов Аркадий Иванович",
                LocalDate.of(2002, 11, 14), 50000.0);
        employees.employment("Истратов", "Денис", "Денисович",
                LocalDate.of(1978, 4, 1), "муж", "2435678",
                "заместитель начальника", "АХО", "Фролов Аркадий Иванович",
                LocalDate.of(2004, 8, 8), 55000.0);
        employees.employment("Ковалева", "Лилия", "Петровна",
                LocalDate.of(1968, 4, 17), "жен", "455678",
                "Специалист", "Отдел кадров", "Авдеева Вера Ивановна",
                LocalDate.of(1998, 5, 14), 44500.0);
        employees.employment("Долгушина", "Кристина", "Семеновна",
                LocalDate.of(1992, 7, 12), "жен", "2235678",
                "Специалист", "Отдел кадров", "Авдеева Вера Ивановна",
                LocalDate.of(2020, 3, 14), 44500.0);
        employees.employment("Хомченко", "Антонина", "Павловна",
                LocalDate.of(1989, 12, 10), "жен", "2235678",
                "Бухгалтер", "Бухгалтерия", "Савилова Динара Константиновна",
                LocalDate.of(2015, 1, 29), 40000.0);
        employees.employment("Васильева", "Анна", "Михайловна",
                LocalDate.of(1989, 11, 11), "жен", "2235678",
                "Бухгалтер", "Бухгалтерия", "Савилова Динара Константиновна",
                LocalDate.of(2019, 10, 12), 40000.0);
        employees.employment("Трофимова", "Анастасия", "Павловна",
                LocalDate.of(1994, 9, 24), "жен", "2235678",
                "Старший бухгалтер", "Бухгалтерия", "Савилова Динара Константиновна",
                LocalDate.of(2002, 1, 28), 50000.0);
        return employees;
    }
}