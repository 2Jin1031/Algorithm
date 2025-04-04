import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int value = Integer.parseInt(br.readLine());
            int sum = 2;
            if (value == 0) {
                break;
            }
            int digit = calculateDigit(value);
            sum += digit - 1;
            
            for (int i = 0; i < digit; i++) {
                int numberScore = 3;
                int number = value % 10;
                value /= 10;
                if (number == 1) {
                    numberScore = 2;
                }
                else if (number == 0) {
                    numberScore = 4;
                }
                sum += numberScore;
            }
            System.out.println(sum);
        }
    }

    private static int calculateDigit(int value) {
        int digit = 0;
        while (value > 0) {
            value /= 10;
            digit++;
        }
        return digit;
    }
}