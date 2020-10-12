import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Enter expression:");
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        try {
            InputExpression inputExpression = new InputExpression(inputData);
            int firstTerm = inputExpression.getFirstTerm();
            int secondTerm = inputExpression.getSecondTerm();
            String operator = inputExpression.getOperator();
            Calculation calculation = new Calculation(firstTerm, secondTerm, operator);
            System.out.println("Result:");
            if (inputExpression.isRoman()) {
                System.out.println(RomanNumeral.transformToRoman(calculation.result()));
            } else {
                System.out.println(calculation.result());
            }
        } catch (InputExpressionException | NumberFormatException e) {
            System.err.println("Incorrectly entered data.");
        }
    }
}
