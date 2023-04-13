import java.util.Scanner;
/*
* Program StepTracker. Storing, editing, targeting and steps statistics for each month
* @version 1.0 13/04/2023
* @author Aleksandr Liagushin
*/
public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(userInput);
        int menuPoint;
        MonthData monthData;

        while (true) {
            Navigator.printMenu();
            menuPoint = userInput.nextInt();
            if (menuPoint == 1) {
                stepTracker.addNewNumberStepsPerDay();
                System.out.println();
            } else if (menuPoint == 2) {
                stepTracker.changeStepGoal();
                System.out.println();
            } else if (menuPoint == 3) {
                Navigator.printConverterMenu();
                menuPoint = userInput.nextInt();
                System.out.println();
                if (menuPoint == 1) {
                    monthData = Navigator.getMonthData(userInput, stepTracker);
                    System.out.printf("В этом месяце вы покрыли дистанцию в %.2f км.\n",
                            (Converter.convertToKm(MonthData.sumStepsFromMonth(monthData))));
                    System.out.println();
                } else if (menuPoint == 2) {
                    monthData = Navigator.getMonthData(userInput, stepTracker);
                    System.out.println("В этом месяце вы сожгли: "
                            + Converter.convertStepsToKilocalories(MonthData.sumStepsFromMonth(monthData)) + " кКал.");
                    System.out.println();
                } else if (menuPoint == 0) {
                    System.out.println("Вы напралены в основное меню.");
                    System.out.println();
                } else {
                    System.out.println("Такого пункта меню не существует.");
                    System.out.println("Вы напралены в основное меню.");
                    System.out.println();
                }
            } else if (menuPoint == 4) {
                monthData = Navigator.getMonthData(userInput, stepTracker);
                Converter.printStatistic(stepTracker, monthData);
                System.out.println();
            } else if (menuPoint == 0) {
                System.out.println("Хорошего дня и достижения поставленных целей!");
                System.out.println();
                return;
            } else {
                System.out.println("Такого пункта меню нет.");
                System.out.println();
            }
        }
    }
}
