import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LinePermutation {
    public static void main(String[] args) {
        String s = "asdfghjkl;qwert";
        String t = "qwert;asdfghjkl";
        String t2 = "34tfgwergrth";
        Map<Integer, Integer> letters = new HashMap<>();

        if (s.length() != t.length()) {
            System.out.println(false);
            return;
        }

        for (int c : s.toCharArray()) {
            if (!letters.containsKey(c)) {
                letters.put(c, 1);
            } else {
                letters.put(c, letters.get(c)+1);
            }
        }

        String str = t;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (!letters.containsKey(c)) {
                System.out.println(false);
                return; 
            }
            int count = letters.get(c)-1;
            letters.put(c, count);
            if (count < 0) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}