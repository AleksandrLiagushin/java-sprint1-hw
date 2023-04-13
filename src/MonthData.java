class MonthData {
    int[] days = new int[30];
    MonthData[] monthToData = new MonthData[12];
    static void printDaysAndStepsFromMonth(StepTracker stepTracker, int month) {
        MonthData monthData = stepTracker.monthToData[month - 1];
        for (int i = 1; i <= monthData.monthToData[month - 1].days.length; i++) {
            System.out.println("День " + i + ": " + monthData.monthToData[month - 1].days[i - 1]);
        }
    }

    int sumStepsFromMonth(int month) {
        int sumSteps = 0;
        for (int i = 1; i <= monthToData[month - 1].days.length; i++) {
            sumSteps += monthToData[month - 1].days[i - 1];
        }
        return sumSteps;
    }

    int maxSteps(MonthData monthData) {
        int maxSteps = 0;
        for (int steps : monthData.days) {
            if (steps > maxSteps) {
                maxSteps = steps;
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay, MonthData monthData) {
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
