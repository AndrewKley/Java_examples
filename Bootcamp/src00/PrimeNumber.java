import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(reader.readLine());

            if (num <= 1) {
                System.out.println("theIllegalArgument");
                return;
            }
            if (num % 2 == 0) {
                System.out.println("false 1");
                return;
            }
            int count = 0;
            for (int i = 3; i < num / 2; i += 2, count++) {
                if (num % i == 0) {
                    System.out.printf("false %d\n", count);
                    return;
                }
            }
            System.out.printf("true %d\n", count);
        } catch (IOException e) { }
    }
}