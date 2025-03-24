import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] priceByCount = new int[4];
        int[] timeTable = new int[101];
        for (int i = 1; i <= 3; i++) {
            priceByCount[i] = Integer.parseInt(st.nextToken());
        }

        int lastIdx = 0;
        for (int loop = 0; loop < 3; loop++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            lastIdx = Math.max(endTime, lastIdx);
            for (int t = startTime; t < endTime; t++) {
                timeTable[t]++;
            }
        }

        int totalPrice = 0;
        for (int t = 0; t < lastIdx; t++) {
            totalPrice += priceByCount[timeTable[t]] * timeTable[t];
        }
        System.out.println(totalPrice);
    }
}
