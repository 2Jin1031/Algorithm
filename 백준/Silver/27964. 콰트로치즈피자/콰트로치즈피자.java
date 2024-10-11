import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (input[i].length() < 6) {
                continue;
            }
            if (!input[i].substring(input[i].length() - 6).equals("Cheese")) {
                continue;
            }
            String type = input[i].substring(0, input[i].length() - 6);
            if (!set.contains(type)) {
                set.add(type);
            }
        }

        if (set.size() >= 4) {
            bw.write("yummy");
        } else {
            bw.write("sad");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}