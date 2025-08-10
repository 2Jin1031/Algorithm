import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long count = 0;
        long start = 1;
        int length = 1;

        while (start * 10 <= N) {
            count += (start * 10 - start) * length;
            start *= 10;
            length++;
        }
        count += (N - start + 1) * length;
        System.out.println(count);
    }
}