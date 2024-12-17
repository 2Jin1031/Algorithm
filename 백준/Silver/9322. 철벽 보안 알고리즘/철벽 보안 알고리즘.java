import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] result = new String[N];
            List<String> arr = Arrays.stream(br.readLine().split(" "))
                    .collect(Collectors.toList());
            List<String> arr2 = Arrays.stream(br.readLine().split(" "))
                    .collect(Collectors.toList());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String value = st.nextToken();
                String ciphertext2Value = arr2.get(i);
                int findIdx = arr.indexOf(ciphertext2Value);
                result[findIdx] = value;
            }

            for (String resultValue : result) {
                bw.write(resultValue + " ");
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }
}