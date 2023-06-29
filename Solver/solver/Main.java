import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] info = scanner.readLine().split(" ");
        String[] weight = scanner.readLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int x = Integer.parseInt(info[1]);
        int t = Integer.parseInt(info[2]);

        HashMap<Integer, ArrayList<Integer>> different = new HashMap<Integer, ArrayList<Integer>>();
    
        for (int i = 0; i < n; i++) {
            int diffTmp = Math.abs(Integer.parseInt(weight[i]) - x);
            if (different.containsKey(i+1)) {
                different.get(diffTmp).add(i+1);
            } else {
                different.put(diffTmp, new ArrayList<Integer>());
                different.get(diffTmp).add(i+1);
            }
        }

        // for (Map.Entry<Integer, ArrayList<Integer>> d : different.entrySet()) {
        //     System.out.print(d.getKey() + ": ");
        //     d.getValue().forEach(day -> System.out.print(day + " "));
        //     System.out.println();
        // }
    }
}
