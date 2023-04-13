import java.util.Scanner;

class Converter {

    Scanner userInput;
    double convertToKm(int steps) {
        // used double because if total covered distance less than 1 km method will return 0
        double stepLength = 0.6;
        return (steps * stepLength / 1000.0);
    }

    int convertStepsToKilocalories(int steps) {
        int burnedKalByStep = 50;
        return (steps * burnedKalByStep / 1000);
    }

    void printStatistic(StepTracker stepTracker) { //MonthData monthData

        int month;
        int sumSteps;

        System.out.println("Введите номер месяца от 1 до 12");
        month = this.userInput.nextInt();
        System.out.println("В этом месяце вы прошли по дням: ");
        MonthData.printDaysAndStepsFromMonth(stepTracker, month);
        System.out.println("Максимальное количество в этом месяце: ");
        System.out.println("Общее количество шагов в этом месяце: ");
        System.out.println("Среднее число шагов в этом месяце: ");
        System.out.println("Всего вы прошли: " + " км");
        System.out.println("Всего вы сожгли: " + " кКал");
        System.out.println("Лучшая серия по достижению цели: " + " дней подряд");
    }
}
