import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        long result = 1;
        for (int i = 2; i < num + 1; i++) {
            result *= i;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}