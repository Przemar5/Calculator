package calculator;

public class Model
{
    public static boolean initialized = false;
    public static String operation = "";
    public static double first;

    public static double calculate(double number)
    {
        double f = first;
        afterCalculations(number);
        switch (operation) {
            case "*": return f * number;
            case "/": return f / number;
            case "+": return f + number;
            case "-": return f - number;
        }
        return 0;
    }

    private static void afterCalculations(double number)
    {
        first = number;
    }
}
