import java.util.Scanner;
/*
 * Class Navigator. Printing menus and getting data from user input
 * @version 1.0 13/04/2023
 * @author Aleksandr Liagushin
 */
class Navigator {

    static void printMenu() {
        // вывод меню
        System.out.println("Степ трекер. Основное меню:");
        System.out.println("1 - Ввести количество шагов");
        System.out.println("2 - Изменить цель по количеству шагов");
        System.out.println("3 - Конверитировать шаги");
        System.out.println("4 - Показать статистику");
        System.out.println("0 - Выйти");
        System.out.println("Что Вы хотите сделать? Введите номер меню:");
    }

    static void printConverterMenu() {
        System.out.println("Во что Вы хотите конвертировать шаги?");
        System.out.println("1 - Километры");
        System.out.println("2 - Калории");
        System.out.println("0 - Выход в основное меню");
    }
    static MonthData getMonthData(Scanner userInput, StepTracker stepTracker) {
        int month;
        MonthData monthData;
        System.out.println("Введите номер месяца от 1 до 12:");
        month = userInput.nextInt();
        monthData = stepTracker.monthToData[month - 1];
        return monthData;
    }
}
