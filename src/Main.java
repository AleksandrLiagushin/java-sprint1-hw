import java.util.Scanner;
/*
* Program StepTracker. Storing, editing, targeting and steps statistics for each month
* @version 1.1 13/04/2023
* @author Aleksandr Liagushin
*/
public class Main {

    protected static final int ADD_STEPS = 1;
    protected static final int CHANGE_TARGET = 2;
    protected static final int CALL_CONVERTER = 3;
    protected static final int PRINT_STAT = 4;
    protected static final int QUIT = 0;
    protected static final int CONVERT_TO_KM = 1;
    protected static final int CONVERT_TO_KKAL = 2;
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(userInput);
        int menuPoint;
        MonthData monthData;

        while (true) {
            Navigator.printMenu();
            menuPoint = userInput.nextInt();
            if (menuPoint == ADD_STEPS) {
                stepTracker.addNewNumberStepsPerDay();
                System.out.println();
            } else if (menuPoint == CHANGE_TARGET) {
                stepTracker.changeStepGoal();
                System.out.println();
            } else if (menuPoint == CALL_CONVERTER) {
                Navigator.printConverterMenu();
                menuPoint = userInput.nextInt();
                System.out.println();
                if (menuPoint == CONVERT_TO_KM) {
                    monthData = Navigator.getMonthData(userInput, stepTracker);
                    System.out.printf("В этом месяце вы покрыли дистанцию в %.2f км.\n",
                            (Converter.convertToKm(MonthData.sumStepsFromMonth(monthData))));
                    System.out.println();
                } else if (menuPoint == CONVERT_TO_KKAL) {
                    monthData = Navigator.getMonthData(userInput, stepTracker);
                    System.out.println("В этом месяце вы сожгли: "
                            + Converter.convertStepsToKilocalories(MonthData.sumStepsFromMonth(monthData)) + " кКал.");
                    System.out.println();
                } else if (menuPoint == QUIT) {
                    System.out.println("Вы напралены в основное меню.");
                    System.out.println();
                } else {
                    System.out.println("Такого пункта меню не существует.");
                    System.out.println("Вы напралены в основное меню.");
                    System.out.println();
                }
            } else if (menuPoint == PRINT_STAT) {
                monthData = Navigator.getMonthData(userInput, stepTracker);
                Converter.printStatistic(stepTracker, monthData);
                System.out.println();
            } else if (menuPoint == QUIT) {
                System.out.println("Хорошего дня и достижения поставленных целей!");
                System.out.println();
                userInput.close();
                return;
            } else {
                System.out.println("Такого пункта меню нет.");
                System.out.println();
            }
        }
    }
}
