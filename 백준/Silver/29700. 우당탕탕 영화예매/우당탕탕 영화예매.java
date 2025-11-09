import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N, M, K;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int startIdx = 0;
            int endIdx = 0;
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '0') {
                    endIdx++;
                } else {
                    int length = endIdx - startIdx;
                    if (length >= K) {
                        map.put(length, map.getOrDefault(length, 0) + 1);
                    }
                    startIdx = endIdx + 1;
                    endIdx = startIdx;
                }
            }
            int length = endIdx - startIdx;
            if (length >= K) {
                map.put(length, map.getOrDefault(length, 0) + 1);
            }
            startIdx = endIdx + 1;
            endIdx = startIdx;
        }

        int ans = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            ans += (key - K + 1) * value;
        }
        System.out.println(ans);
    }
}