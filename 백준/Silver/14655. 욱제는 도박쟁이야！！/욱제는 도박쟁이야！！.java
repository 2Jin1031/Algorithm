import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum1 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum1 += Math.abs(Integer.parseInt(st.nextToken()));
        }

        int sum2 = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum2 += Math.abs(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sum1 + sum2);
    }
}
