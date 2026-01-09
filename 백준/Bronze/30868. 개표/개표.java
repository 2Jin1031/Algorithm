import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String five = "++++";

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int fiveNum = n / 5;
            int oneNum = n % 5;

            sb = new StringBuilder();
            for (int i = 0; i < fiveNum; i++) {
                sb.append(five).append(" ");
            }

            for (int i = 0; i < oneNum; i++) {
                sb.append("|");
            }
            sb.append("\n");
            System.out.print(sb);
        }
    }
}