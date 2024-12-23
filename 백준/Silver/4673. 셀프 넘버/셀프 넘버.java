import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static boolean[] arr = new boolean[10002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 0;
        while (idx < 10000) {
            idx++;
            if (arr[idx]) {
                continue;
            }
            bw.write(idx + "\n");
            processSelfNumber(idx);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void processSelfNumber(int value) {
        if (value > 10000 || arr[value]) {
            return ;
        }
        arr[value] = true;
        int sum = value;
        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }
        processSelfNumber(sum);
    }
}