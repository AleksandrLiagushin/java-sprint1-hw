/*
 * Class MonthData. Storing month data, calculating maxSteps, total steps, the best series and print all data for selected month
 * @version 1.0 13/04/2023
 * @author Aleksandr Liagushin
 */
class MonthData {
    int[] days = new int[30];

    static void printDaysAndStepsFromMonth(MonthData monthData) {
        for (int i = 1; i <= monthData.days.length; i++) {
            System.out.println("День " + i + ": " + monthData.days[i - 1]);
        }
    }

    static int sumStepsFromMonth(MonthData monthData) {
        int sumSteps = 0;
        for (int steps : monthData.days) {
            sumSteps += steps;
        }
        return sumSteps;
    }

    static int maxSteps(MonthData monthData) {
        int maxSteps = 0;
        for (int steps : monthData.days) {
            if (steps > maxSteps) {
                maxSteps = steps;
            }
        }
        return maxSteps;
    }

    static int bestSeries(int goalByStepsPerDay, MonthData monthData) {
        int bestSeries = 0;
        int currentSeries = 0;
        for (int steps : monthData.days) {
            if (steps >= goalByStepsPerDay) {
                currentSeries++;
            } else if (currentSeries > bestSeries){
                bestSeries = currentSeries;
                currentSeries = 0;
            } else {
                currentSeries = 0;
            }
        }
        return bestSeries;
    }
}
