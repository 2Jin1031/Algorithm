import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int P = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < P; loop++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int caseNum = Integer.parseInt(st.nextToken());

            ArrayList<Integer> arr = new ArrayList<>();
            int ans = 0;
            for (int i = 0; i < 20; i++) {
                int height = Integer.parseInt(st.nextToken());
                int idx = Collections.binarySearch(arr, height);
                idx = (-idx) - 1;
                ans += i - idx;
                arr.add(height);
                Collections.sort(arr);
            }

            System.out.println(String.format("%d %d", caseNum, ans));
        }
    }
}