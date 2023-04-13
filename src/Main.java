import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // вывод меню и обработка запросов пользователя
        Scanner userInput = new Scanner(System.in);
        Navigator navigator = new Navigator(userInput);
        StepTracker stepTracker = new StepTracker(userInput);
        Converter converter = new Converter();
        //MonthData monthData = new MonthData();
        int month;
        int sumSteps;
        while (true) {
            navigator.printMenu();
            int menuPoint = userInput.nextInt();
            if (menuPoint == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (menuPoint == 2) {
                System.out.println("Введите цель по количеству шагов за день:");
                stepTracker.changeStepGoal();
            } else if (menuPoint == 3) {
                while (true) {
                    Navigator.printConverterMenu();
                    menuPoint = userInput.nextInt();
                    if (menuPoint == 1) {
                        System.out.println("Введите номер месяца от 1 до 12:");
                        month = userInput.nextInt();
                        MonthData monthData = stepTracker.monthToData[month - 1];
                        sumSteps = monthData.sumStepsFromMonth(month);
                        System.out.println("В этом месяце вы прошли: " + converter.convertToKm(sumSteps)); //+ converter.convertToKm(sumSteps)
                    } else if (menuPoint == 2) {
                        System.out.println("Введите номер месяца от 1 до 12:");
                        month = userInput.nextInt();
                        MonthData monthData = stepTracker.monthToData[month - 1];
                        sumSteps = monthData.sumStepsFromMonth(month);
                        System.out.println("В этом месяце вы сожгли: " + converter.convertStepsToKilocalories(sumSteps) + " кКал.");
                    } else if (menuPoint == 0) {
                        break;
                    } else {
                        System.out.println("Такого пункта меню нет, повторите ввод");
                    }
                }
            } else if (menuPoint == 4) {
                converter.printStatistic(stepTracker);
            }else if (menuPoint != 0) {
                System.out.println("Такого пункта меню нет. Повторите ввод:");
            }
            //return 0; //todo проверь значение перед компиляцией
        }
    }
}
