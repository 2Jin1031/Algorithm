import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int personCount = 8;
        int timeLimit = 210;
        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int personIdx = K - 1;
        int totalUsingTime = 0;
        int result = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int usingTime = Integer.parseInt(st.nextToken());
            totalUsingTime += usingTime;
            String intent = st.nextToken();

            if (totalUsingTime >= timeLimit && result == -1) {
                result = personIdx + 1;
            }
            if (intent.equals("T")) {
                personIdx = (personIdx + 1) % personCount;
            }
        }
        System.out.println(result);
    }
}