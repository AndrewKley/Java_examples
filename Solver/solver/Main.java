import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        Map<Integer, Integer> days = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            days.put(i, num);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(days.get(i));
        }
    }
}
