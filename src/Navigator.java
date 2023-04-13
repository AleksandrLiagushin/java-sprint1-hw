import java.util.Scanner;

class Navigator {
    Scanner userInput;
    public Navigator(Scanner userInput){
        this.userInput = userInput;
    }
    void printMenu() {
        // вывод меню
        System.out.println("Степ трекер. Основное меню");
        System.out.println("1 - Ввести количество шагов");
        System.out.println("2 - Изменить цель по количеству шагов");
        System.out.println("3 - Конверитировать шаги");
        System.out.println("4 - Показать статистику");
        System.out.println("0 - Выйти");
        System.out.println("Что Вы хотите сделать? Введите номер меню:");
    }

    int navigate() {
        int menuPoint = userInput.nextInt();
        if (menuPoint == 1) {
            System.out.println("");


        } else if (menuPoint == 2) {
            System.out.println("Введите цель по количеству шагов за день:");
            // todo записать новую цель на месяц или обновить
        } else if (menuPoint == 3) {
            while (true) {
                printConverterMenu();
                menuPoint = userInput.nextInt();
                if (menuPoint == 1) {
                    return 0;
                } else if (menuPoint == 2) {
                    // todo вызвать конвертер с пересчетом в каллории
                    return 0;
                } else if (menuPoint == 0) {
                    return -1; //-1 возврат в основное меню; 0 выход из программы
                } else {
                    System.out.println("Такого пункта меню нет, повторите ввод");
                }
            }
        } else if (menuPoint != 0) {
            System.out.println("Такого пункта меню нет. Повторите ввод:");
        }
        return 0; //todo проверь значение перед компиляцией
    }

    static void printConverterMenu() {
        System.out.println("Во что Вы хотите конвертировать шаги?");
        System.out.println("1 - Километры");
        System.out.println("2 - Калории");
        System.out.println("0 - Выход в основное меню");
    }
    void checkUserInput() {

    }
}
