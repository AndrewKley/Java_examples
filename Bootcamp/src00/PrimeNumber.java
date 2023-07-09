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
            
            int i = 2;
            for (; i*i <= num / 2+1; i++) {
                if (num % i == 0) {
                    System.out.printf("false %d\n", i - 2);
                    return;
                }
            }
            System.out.printf("true %d\n", i-1);
        } catch (IOException e) { }
    }
}