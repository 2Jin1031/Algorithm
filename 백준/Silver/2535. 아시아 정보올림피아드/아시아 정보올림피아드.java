import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Map<Integer, int[]> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            map.put(score, new int[]{a, b});
        }

        int[] arr = new int[101];

        int ans = 0;
        for (int score : map.keySet()) {
            int[] info = map.get(score);

            int countryNum = info[0];
            if(arr[countryNum] >= 2) {
                continue;
            }

            arr[countryNum]++;
            ans++;
            System.out.println(info[0] + " " + info[1]);
            if (ans >= 3) {
                break;
            }
        }
    }
}