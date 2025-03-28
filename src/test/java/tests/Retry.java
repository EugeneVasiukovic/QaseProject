package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int attempt = 0; // Начинаем с 0 попыток
    private static final int MAX_RETRY = 5; // Максимальное количество попыток

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (attempt < MAX_RETRY) {
                attempt++;
                System.out.println("Retrying test " + result.getName() + " for the " + attempt + " time.");
                return true;
            }
        }
        return false;
    }
}