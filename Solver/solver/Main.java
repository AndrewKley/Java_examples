import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] info = scanner.readLine().split(" ");
        String[] weight = scanner.readLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int x = Integer.parseInt(info[1]);
        int t = Integer.parseInt(info[2]);

        String res = "";
        int[] different = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            different[i] = Math.abs(Integer.parseInt(weight[i]) - x);
            int min = different[i];
            if (min == -1 || t - different[i] < 0) continue;
            if (t - min >= 0 && different[i] != -1) {
                t -= min;
                different[i] = -1;
                res += i + 1 + " ";
                count++;
            }
        }

        System.out.println(count);
        System.out.println(res);
    }
}
