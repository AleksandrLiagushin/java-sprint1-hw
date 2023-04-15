/*
 * Class Converter. Conversion selected month data to km kKal and print statistic
 * @version 1.1 13/04/2023
 * @author Aleksandr Liagushin
 */
class Converter {

    static double convertToKm(int steps) {
        // used double because if total covered distance less than 1 km method will return 0
        /* При росте в 182 см мой средний шаг сотавляет 69 см (прогулочный 60, быстрый 75). Размер для конвертации в ТЗ предложен некорректный.
        * Средний рост населения нашей страны составляет 176см для мужчин и 165 для женщин, соответвенно и размер среднего шага меньше
        * Правильно в этом случае использовать запрос биологических данных пользователя
        * Во-вторых формулировка "можно использовать" никак не обязывает меня использовать конкретно это значение 75 см
        */
        double stepLength = 0.65;
        return (steps * stepLength / 1000.0);
    }

    static int convertStepsToKilocalories(int steps) {
        int burnedKalByStep = 50;
        return (steps * burnedKalByStep / 1000);
    }
    // В ТЗ задача описать этот метод в этом классе. Согласен что его можно выделить в отдельный класс, но при условии что класс
    // будет иметь еще несколько методов. Плодить классы по одному методу не самая хорошая практика
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
