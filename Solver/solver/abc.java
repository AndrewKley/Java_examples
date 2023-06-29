import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] key = scanner.nextLine().split(" ");
        String[] level = scanner.nextLine().split(" ");
        int k = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split(" ");

        Map<String, Integer> keyboard = new HashMap<>(); 
        for (int i = 0; i < n; i++) {
            keyboard.put(key[i], Integer.parseInt(level[i]));
        }

        int count = 0;
        int currLvl = keyboard.get(line[0]);
        for (String s : line) {
            if (currLvl != keyboard.get(s)) {
                count += 1;
            }
            currLvl = keyboard.get(s);
        }

        System.out.println(count);

        scanner.close();
    }
}