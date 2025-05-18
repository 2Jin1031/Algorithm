import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int totalTime = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            int time = Integer.parseInt(st.nextToken());
            totalTime += time + 8;
        }
        int time = Integer.parseInt(st.nextToken());
        totalTime += time;

        int consumeDay = totalTime / 24;
        int consumeTime = totalTime % 24;

        System.out.println(consumeDay + " " + consumeTime);
    }
}