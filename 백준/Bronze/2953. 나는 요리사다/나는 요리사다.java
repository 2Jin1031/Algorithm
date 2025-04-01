import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalScore = 0;
            for (int j = 0; j < 4; j++) {
                totalScore += Integer.parseInt(st.nextToken());
            }
            arr.add(totalScore);
        }

        int maxIdx = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < 5; i++) {
            if (maxValue < arr.get(i)) {
                maxValue = Math.max(maxValue, arr.get(i));
                maxIdx = i;
            }
        }

        int resultNumber = maxIdx + 1;
        System.out.println(resultNumber + " " + maxValue);
    }
}