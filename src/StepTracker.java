import java.util.Scanner;

class StepTracker {
    Scanner userInput;
    int goalByStepsPerDay;
    MonthData[] monthToData = new MonthData[12];
    StepTracker(Scanner scan) {
        userInput = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        int month;
        int day;

        System.out.println("Введите номер месяца от 1 до 12:");
        month = userInput.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Неверный месяц. Вы направлены в основное меню.");
            return;
        }

        System.out.println("Введите день от 1 до 30 включительно:");
        day = userInput.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Неверная дата. Вы направлены в основное меню");
            return;
        }

        System.out.println("Введите количество пройденных щагов");
        int stepsQuantity;
        stepsQuantity = userInput.nextInt();
        if (stepsQuantity < 0) {
            System.out.println("Количество шагов не может быть меньше нуля. Вы направлены в основное меню.");
        }
        MonthData monthData = monthToData[month - 1];
        monthData.monthToData[month - 1].days[day - 1] = stepsQuantity;

    }

    void changeStepGoal() {
        System.out.println("Введите новую цель по количеству пройденных шагов");
        goalByStepsPerDay = userInput.nextInt();
    }
}
