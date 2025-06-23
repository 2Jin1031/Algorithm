import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] timeUnit = {3600, 60, 1};
        String[] arr1 = br.readLine().split(" : ");
        String[] arr2 = br.readLine().split(" : ");

        int srcTime = 0;
        for (int i = 0; i < 3; i++) {
            srcTime += Integer.parseInt(arr1[i]) * timeUnit[i];
        }

        int descTime = 0;
        for (int i = 0; i < 3; i++) {
            descTime += Integer.parseInt(arr2[i]) * timeUnit[i];
        }

        if (srcTime > descTime) {
            descTime += 24 * timeUnit[0];
        }
        int ans = descTime - srcTime;
        System.out.println(ans);
    }
}