import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int t = 0; t < N; t++) {
            String input = br.readLine();
            String smallest = findSmallestRotation(input);
            set.add(smallest);
        }

        bw.write(set.size() + "\n");
        bw.close();
        br.close();
    }

    private static String findSmallestRotation(String input) {
        String smallest = input;
        int len = input.length();
        String doubled = input + input; // 두 배로 늘려서 회전 쉽게 처리
        for (int i = 1; i < len; i++) {
            String rotated = doubled.substring(i, i + len);
            if (rotated.compareTo(smallest) < 0) {
                smallest = rotated;
            }
        }
        return smallest;
    }
}