import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int digit10 = N / 10;
        int digit1 = N % 10;

        if (digit10 == digit1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}