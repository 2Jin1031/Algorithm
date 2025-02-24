import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = 0, idx = 0;
        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            if (input.contains("Fizz") || input.contains("Buzz")) {
                continue;
            }
            value = Integer.parseInt(input);
            idx = i;
            break;
        }

        int result = value + 3 - idx;
        if (result % 3 == 0 && result % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (result % 3 == 0) {
            System.out.println("Fizz");
        } else if (result % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(result);
        }
    }
}