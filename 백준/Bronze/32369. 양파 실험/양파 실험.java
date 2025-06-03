import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int aLength = 1;
        int bLength = 1;
        for (int i = 0; i < N; i++) {
            aLength += A;
            bLength += B;

            if (aLength < bLength) {
                int tmp = aLength;
                aLength = bLength;
                bLength = tmp;
            } else if (aLength == bLength) {
                bLength--;
            }
        }

        System.out.println(aLength + " " + bLength);
    }
}