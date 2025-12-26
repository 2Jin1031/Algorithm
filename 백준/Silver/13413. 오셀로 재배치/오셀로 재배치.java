import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String str1 = br.readLine();
            String str2 = br.readLine();

            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < str1.length(); i++) {
                int num = str1.charAt(i) - str2.charAt(i); 
                if (num > 0) {
                    count1++;
                } else if (num < 0) {
                    count2++;
                }
            }

            int ans = Math.min(count1, count2) + Math.abs(count1 - count2);
            System.out.println(ans);
        }
    }
}