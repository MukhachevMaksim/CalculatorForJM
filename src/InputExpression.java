public class InputExpression {
    private String inputExpression;

    public InputExpression(String inputExpression) throws InputExpressionException {
        this.inputExpression = inputExpression;
        if (!containOneOperator()) {
            throw new InputExpressionException("Wrong number of operators.");
        }
    }

    private boolean containOneOperator() { //если в выражении количество операторов не равняется одному, при вызове конструктора вылетит исключение
        String[] inputExpressionArray = inputExpression.split("");
        int amountOfOperators = 0;
        for (String s: inputExpressionArray) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                amountOfOperators++;
            }
        }
        return amountOfOperators == 1;
    }

    public String getOperator() {
        String[] arithmeticOperators = {"+", "-", "/", "*"};
        String requiredOperator = "";
        for (String s: arithmeticOperators) {
            if (inputExpression.contains(s)) {
                requiredOperator = s;
                break;
            }
        }
        return requiredOperator;
    }

    private String firstTermString() {                              //возвращает строку стоящую слева от оператора
        int indexOfOperator = inputExpression.indexOf(getOperator());
        return inputExpression.substring(0, indexOfOperator).trim();
    }

    private String secondTermString() {                             //возвращает строку стоящую справа от оператора
        int indexOfOperator = inputExpression.indexOf(getOperator());
        return inputExpression.substring(indexOfOperator + 1).trim();
    }

    public boolean isRoman() {           // проверяет, являются ли одновременно два члена римскими числами
        try {
            RomanNumeral.valueOf(firstTermString());
            RomanNumeral.valueOf(secondTermString());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public int getFirstTerm() throws NumberFormatException {
        if (isRoman()) {
            return RomanNumeral.valueOf(firstTermString()).getValue();
        } else {
            return Integer.parseInt(firstTermString());
        }
    }

    public int getSecondTerm() throws NumberFormatException {
        if (isRoman()) {
            return RomanNumeral.valueOf(secondTermString()).getValue();
        } else {
            return Integer.parseInt(secondTermString());
        }
    }

}
