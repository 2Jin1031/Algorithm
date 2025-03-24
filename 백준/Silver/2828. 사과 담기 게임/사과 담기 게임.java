import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());
        int cartStart = 1;
        int cartEnd =  M;

        int moveCount = 0;
        for (int j = 0; j < J; j++) {
            int v = Integer.parseInt(br.readLine());

            int diff = 0;
            if (v < cartStart) {
                diff = v - cartStart;
            }
            else if (v > cartEnd) {
                diff = v - cartEnd;
            }

            moveCount += Math.abs(diff);
            cartStart += diff;
            cartEnd += diff;
        }
        System.out.println(moveCount);
    }
}
