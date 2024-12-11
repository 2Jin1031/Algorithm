import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int SCount = 0;
        int LCount = 0;
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            char value = input.charAt(i);
            if (value == 'R' || value == 'L') {
                if (value == 'L') {
                    LCount++;
                    continue;
                }
                if (LCount == 0) {
                    break;
                } else {
                    LCount--;
                    result++;
                }
            } else if (value == 'K' || value == 'S') {
                if (value == 'S') {
                    SCount++;
                    continue;
                }
                if (SCount == 0) {
                    break;
                } else {
                    SCount--;
                    result++;
                }
            } else {
                result++;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}