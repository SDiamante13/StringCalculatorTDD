import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        List<Integer> negativeList = new ArrayList<>();
        int integerAtOne;
        char customDelimiter = 'z';
        if(!numbers.isEmpty() && numbers.charAt(0) == '/') {
            customDelimiter = numbers.charAt(2);
        }
        String[] num = numbers.split(",|\\n|" + customDelimiter);
        int result = 0;
        if(num.length > 1) {
            int start = 0;
            if (customDelimiter != 'z') {
                start = 2;
            }
            for (int position = start; position < num.length; position++) {

                int integerNumber = Integer.parseInt(num[position]);
                if (integerNumber < 0) {
                    negativeList.add(integerNumber);
                }
                result += integerNumber;
            }
            if (!negativeList.isEmpty()) {
                throw new NumberFormatException(String.format("negatives not allowed %s", negativeList.toString()));
            }
            return result;
        } else {
            if (num[0] == "") {
                return 0;
            }
            integerAtOne = Integer.parseInt(num[0]);
            if (integerAtOne < 0) {
                throw new NumberFormatException("negatives not allowed " + integerAtOne);
            }
        }

       return integerAtOne;
    }
}
