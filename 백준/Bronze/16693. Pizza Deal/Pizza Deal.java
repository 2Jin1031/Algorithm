import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        double a2 = r1 * r1 * Math.PI;

        double e1 = (double) a1 / p1;
        double e2 = a2 / p2;

        if (e1 > e2) {
            System.out.println("Slice of pizza");
        } else {
            System.out.println("Whole pizza");
        }
    }
}