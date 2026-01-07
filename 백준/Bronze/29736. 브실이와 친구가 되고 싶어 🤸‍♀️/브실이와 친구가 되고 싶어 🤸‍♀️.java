import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
       
        int minFriend = K - X;
        int maxFriend = K + X;
        
        int actualMin = Math.max(A, minFriend);
        int actualMax = Math.min(B, maxFriend);
        
        if (actualMin > actualMax) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(actualMax - actualMin + 1);
        }
    }
}