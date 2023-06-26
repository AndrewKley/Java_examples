import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1)); 
        System.out.println(solution.intToRoman(2)); 
        System.out.println(solution.intToRoman(3)); 
        System.out.println(solution.intToRoman(4)); 
        System.out.println(solution.intToRoman(5)); 
        System.out.println(solution.intToRoman(6)); 
        System.out.println(solution.intToRoman(7)); 
        System.out.println(solution.intToRoman(8)); 
        System.out.println(solution.intToRoman(9)); 
        System.out.println(solution.intToRoman(10)); 
        System.out.println(solution.intToRoman(12)); 
        System.out.println(solution.intToRoman(58)); 
        System.out.println(solution.intToRoman(93)); 
        System.out.println(solution.intToRoman(1994)); 
        System.out.println(solution.intToRoman(30)); 
        System.out.println(solution.intToRoman(36)); 
        System.out.println(solution.intToRoman(80)); 
        System.out.println(solution.intToRoman(74)); 
        System.out.println(solution.intToRoman(41)); 
        System.out.println(solution.intToRoman(104)); 
        System.out.println(solution.intToRoman(1004)); 
        System.out.println(solution.intToRoman(404)); 
        System.out.println(solution.intToRoman(904)); 
        System.out.println(solution.intToRoman(504)); 
        System.out.println(solution.intToRoman(604)); 
    }
}

class Solution {
    Map<Integer, String> symbols = new HashMap<Integer, String>();
    
    private void initSymdols() {
        symbols.put(1, "I");
        symbols.put(5, "V");
        symbols.put(10, "X");
        symbols.put(50, "L");
        symbols.put(100, "C");
        symbols.put(500, "D");
        symbols.put(1000, "M");
    }

    public String intToRoman(int num) {
        initSymdols();
        StringBuilder res = new StringBuilder();
        int countDigits = 1, divider = 10;
        int tmp = num;

        while (tmp / 10 > 0) {
            divider *= 10;
            countDigits *= 10;
            tmp /= 10;
        }

        for (int i = num; i > 0;) {
            if (countDigits == i) {
                res.append(symbols.get(countDigits));
                i -= countDigits;
                divider /= 10;
                countDigits /= 10;
                continue;
            }
            if (divider - countDigits <= i) {
                res.append(symbols.get(countDigits) + symbols.get(divider));
                i -= divider - countDigits;
                removeDifferent(i, countDigits, divider); 
                // for (; getDifferent(i, countDigits) != 0;) {
                //     divider /= 10;
                //     countDigits /= 10;
                // }
                continue;
            }
            if (i >= divider / 2) {
                res.append(symbols.get(divider / 2));
                i -= divider / 2;
                removeDifferent(i, countDigits, divider); 
                // for (; getDifferent(i, countDigits) != 0;) {
                //     divider /= 10;
                //     countDigits /= 10;
                // }
                continue;
            }
            if (divider / 2 - countDigits <= i) {
                res.append(symbols.get(countDigits) + symbols.get(divider / 2));
                i -= divider / 2 - countDigits;
                removeDifferent(i, countDigits, divider); 
                // for (; getDifferent(i, countDigits) != 0;) {
                //     divider /= 10;
                //     countDigits /= 10;
                // }
                continue;
            }
            if (i > countDigits && countDigits >= 10) {
                i -= countDigits;
                res.append(symbols.get(countDigits));
                removeDifferent(i, countDigits, divider); 
                // for (; getDifferent(i, countDigits) != 0;) {
                //     divider /= 10;
                //     countDigits /= 10;
                // }
                continue;
            }
            res.append(getSingle(i));
            i -= i;
        }

        return res.toString();
    }

    private void removeDifferent(int i, Integer countDigits, Integer divider) {
        for (; getDifferent(i, countDigits) != 0;){
            divider /= 10;
            countDigits /= 10;
        }
    }

    private String getSingle(int num) {
        String res = "";
        for (int i = 0; i < num; i++) {
            res += "I";
        }
        return res;
    }

    private int getDifferent(int a, int b) {
        int resA = 0, resB = 0;
        while (a / 10 > 0) {
            resA += 1;
            a /= 10;
        }
        while (b / 10 > 0) {
            resB += 1;
            b /= 10;
        }
        return Math.abs(resA - resB);
    }
}
