import java.util.Scanner;

public class Ab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split(" ");
        String[] weight = scanner.nextLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int x = Integer.parseInt(info[1]);
        int t = Integer.parseInt(info[2]);

        String res = "";
        int[] different = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            different[i] = Math.abs(Integer.parseInt(weight[i]) - x);
            int min = different[i];
            if (min == -1) continue;
            if (t - min >= 0 && different[i] != -1) {
                t -= min;
                different[i] = -1;
                res += i + 1 + " ";
                count++;
            }
        }

        System.out.println(count);
        System.out.println(res);

        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] days = scanner.nextLine().split(" ");

        ArrayList<Integer> solvery = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            solvery.add(Integer.parseInt(days[i]));
        }

        scanner.close();
    }
}