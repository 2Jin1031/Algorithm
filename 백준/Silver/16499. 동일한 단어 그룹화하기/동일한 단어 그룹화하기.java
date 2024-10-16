import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            int[] list = new int[26];
            for (int j = 0; j < str.length(); j++) {
                list[str.charAt(j) - 'a']++;
            }

            set.add(Arrays.toString(list));
        }

        bw.write(set.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}