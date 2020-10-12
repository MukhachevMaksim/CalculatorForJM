public enum RomanNumeral {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);

    private int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String transformToRoman(int arabicNumb) {
        if (arabicNumb == 0) {
            return "0";
        }
        boolean isNegative = false;
        if (arabicNumb < 0 ) {
            isNegative = true;
            arabicNumb *= -1;
        }
        int[] romanValues = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < romanValues.length; i++) {
            while (arabicNumb >= romanValues[i]) {
                arabicNumb -= romanValues[i];
                result.append(romanSymbols[i]);
            }
        }
        if (isNegative) {
            return result.insert(0, "-").toString();
        } else {
            return result.toString();
        }
    }
}
