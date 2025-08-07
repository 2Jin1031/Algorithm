import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int count = 0;

        while (X > 0) {
            if (X % 2 == 1) {
                count++;
            }

            X = X / 2;
        }

        System.out.println(count);
    }
}