import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            
            int s1 = 0, s2 = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String p1 = st.nextToken();
                String p2 = st.nextToken();

                if (p1winner(p1, p2) == 1) {
                    s1++;
                } else if (p1winner(p1, p2) == -1) {
                    s2++;
                } else {
                    s1++;
                    s2++;
                }
            }

            if (s1 > s2) {
                System.out.println("Player 1");
            } else if (s1 < s2) {
                System.out.println("Player 2");
            } else {
                System.out.println("TIE");
            }
        }
    }

    private static int p1winner(String p11, String p22) {
        char p1 = p11.charAt(0);
        char p2 = p22.charAt(0);
        if (p1 == 'R') {
            if (p2 == 'R') {
                return 0;
            } else if (p2 == 'S') {
                return 1;
            } else {
                return -1;
            }
        } else if (p1 == 'S') {
            if (p2 == 'S') {
                return 0;
            } else if (p2 == 'P') {
                return 1;
            } else {
                return -1;
            }
        } else {
            if (p2 == 'P') {
                return 0;
            } else if (p2 == 'R') {
                return 1;
            } else {
                return -1;
            }
        }
    }
}