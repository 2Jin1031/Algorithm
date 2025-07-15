import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int sumCount = 0;
            double sumGrade = 0.0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int count = Integer.parseInt(st.nextToken());
                double grade = Double.parseDouble(st.nextToken());
                sumCount += count;
                sumGrade += count * grade;
            }
            System.out.print(sumCount + " ");
            System.out.println(String.format("%.1f", sumGrade / sumCount));
        }
    }
}