import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        int res = 0;

        do {
            res += num % 10;
            num /= 10;
        } while (num / 10 > 0);
        res += num % 10;

        System.out.println(res);
        reader.close();
    }
}