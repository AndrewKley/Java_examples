import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BTask {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] info = scanner.readLine().split(" ");
        String[] weight = scanner.readLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int x = Integer.parseInt(info[1]);
        int t = Integer.parseInt(info[2]);
        int tmpT = t;
        int count = 0;

        Set<Integer> indexesDiff = new HashSet<>();
        int[] different = new int[n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j < n; j++) {
                if (i == j || indexesDiff.contains(j)) continue;
                int minDiff = Math.abs(Integer.parseInt(weight[min]) - x);
                int currDiff = Math.abs(Integer.parseInt(weight[j]) - x);

                if (indexesDiff.contains(min)) {
                    minDiff = currDiff + 1;
                }
                if (currDiff < minDiff) {
                    min = j;
                }
            }
            different[k++] = min;
            indexesDiff.add(min);
            int diff = Math.abs(Integer.parseInt(weight[min]) - x);
            if (tmpT - diff >= 0) {
                tmpT -= diff;
                count++;
            }
        }

        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(different[i]+1);
        }
    }
}
