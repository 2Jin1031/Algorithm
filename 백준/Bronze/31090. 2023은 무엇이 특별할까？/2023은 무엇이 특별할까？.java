import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int year = Integer.parseInt(br.readLine());

            int nextYear = year + 1;
            int value = year % 100;

            String ans = "";
            if (nextYear % value == 0) {
                ans = "Good";
            } else {
                ans = "Bye";
            }

            System.out.println(ans);
        }
    }
}