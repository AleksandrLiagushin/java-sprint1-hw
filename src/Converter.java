/*
 * Class Converter. Conversion selected month data to km kKal and print statistic
 * @version 1.0 13/04/2023
 * @author Aleksandr Liagushin
 */
class Converter {

    static double convertToKm(int steps) {
        // used double because if total covered distance less than 1 km method will return 0
        double stepLength = 0.6;
        return (steps * stepLength / 1000.0);
    }

    static int convertStepsToKilocalories(int steps) {
        int burnedKalByStep = 50;
        return (steps * burnedKalByStep / 1000);
    }

    static void printStatistic(StepTracker stepTracker, MonthData monthData) {

        System.out.println("В этом месяце вы прошли по дням: ");
        MonthData.printDaysAndStepsFromMonth(monthData);
        System.out.println("Максимальное количество шагов в этом месяце: " + MonthData.maxSteps(monthData) + ".");
        System.out.println("Общее количество шагов в этом месяце: " + MonthData.sumStepsFromMonth(monthData) + ".");
        System.out.println("Среднее число шагов в этом месяце: "
                + (MonthData.sumStepsFromMonth(monthData) / monthData.days.length) + ".");
        System.out.printf("Всего вы прошли: %.2f км.\n", Converter.convertToKm(MonthData.sumStepsFromMonth(monthData)));
        System.out.println("Всего вы сожгли: "
                + Converter.convertStepsToKilocalories(MonthData.sumStepsFromMonth(monthData)) + " кКал.");
        System.out.println("Лучшая серия по достижению цели: "
                + MonthData.bestSeries(stepTracker.goalByStepsPerDay, monthData) + " дней подряд.");
    }
}
