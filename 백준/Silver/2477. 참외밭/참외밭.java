import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;

        List<Integer> arr = new ArrayList<>(6);
        int maxLength = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int direaction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            arr.add(length);
            maxLength = Math.max(maxLength, length);
        }

        int maxIdx = arr.indexOf(maxLength);
        int secondIdx = 0;
        int secondLength = 0;
        if (arr.get((maxIdx + 5) % 6) > arr.get((maxIdx + 1) % 6)) {
            secondLength = arr.get((maxIdx + 5) % 6);
            secondIdx = (maxIdx + 5) % 6;
        } else {
            secondLength = arr.get((maxIdx + 1) % 6);
            secondIdx = (maxIdx + 1) % 6;
        }

        int leftIdx = Math.min(maxIdx, secondIdx);
        int rightIdx = Math.max(maxIdx, secondIdx);
        if (rightIdx - leftIdx != 1) {
            int tmp  = rightIdx;
            rightIdx = leftIdx;
            leftIdx = tmp;
        }

        int out1 = arr.get((leftIdx + 4) % 6);
        int out2 = arr.get((rightIdx + 2) % 6);

        
        int ans = (maxLength * secondLength - out1 * out2) * K;
        System.out.println(ans);
    }
}