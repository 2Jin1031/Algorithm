import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int x = 665;

        while (count < n) {
            x++;
            if (hasTripleSix(x)) count++;
        }

        System.out.print(x);
    }

    private static boolean hasTripleSix(int x) {
        while (x > 0) {
            if (x % 1000 == 666) return true;
            x /= 10;
        }
        return false;
    }
}