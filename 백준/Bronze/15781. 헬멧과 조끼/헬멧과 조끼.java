import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int maxHelmet = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            maxHelmet = Math.max(maxHelmet, Integer.parseInt(st.nextToken()));
        }

        int maxVest = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            maxVest = Math.max(maxVest, Integer.parseInt(st.nextToken()));
        }

        System.out.println(maxHelmet + maxVest);
    }
}