public class Calculation {
    private int firstTerm;
    private int secondTerm;
    private String operator;

    public Calculation (int firstTerm, int secondTerm, String operator) throws InputExpressionException {
        if ((firstTerm < 1 || firstTerm > 10) || (secondTerm < 1 || secondTerm > 10)) {
            throw new InputExpressionException("Numbers are out of range.");
        }
        this.firstTerm = firstTerm;
        this.secondTerm = secondTerm;
        this.operator = operator;
    }

    private int sum() {
        return firstTerm + secondTerm;
    }

    private int difference() {
        return firstTerm - secondTerm;
    }

    private int multiplication() {
        return firstTerm * secondTerm;
    }

    private int division() {
        return firstTerm / secondTerm;
    }

    public int result() {
        int res = 0;
        switch (operator) {
            case "+" : res = sum(); break;
            case "-" : res = difference(); break;
            case "*" : res = multiplication();break;
            case "/" : res = division(); break;
        }
        return res;
    }
}