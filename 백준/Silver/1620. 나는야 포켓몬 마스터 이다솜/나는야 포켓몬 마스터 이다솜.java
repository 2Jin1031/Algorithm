import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static String[] arr;
    private static Map<String, Integer> nameMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initialize(br);
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (isNumber(input)) {
                bw.write(arr[Integer.parseInt(input)] + "\n");
            } else {
                bw.write(nameMap.get(input) + "\n");
            }
        }

        bw.close();
        br.close();
    }

    private static void initialize(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N + 1];
        nameMap = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            arr[i] = br.readLine();
            nameMap.put(arr[i], i);
        }
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}