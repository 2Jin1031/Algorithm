import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        N = Integer.parseInt(br.readLine());

        int result = N % 7;
        if (result == 2) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}