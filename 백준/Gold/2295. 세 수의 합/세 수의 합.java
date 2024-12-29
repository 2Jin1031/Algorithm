import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (int i = N - 1; i >= 0; i--) {
            int findValue = list.get(i);
            boolean found = false;
            for (int j = 0; j < N - 1; j++) {
                int left = j;
                int right = N - 1;

                while (left <= right) {
                    int sum = list.get(j) + list.get(left) + list.get(right);

                    if (sum == findValue) {
                        System.out.println(findValue);
                        found = true;
                        break;
                    } else if (sum < findValue) {
                        left++;
                    } else {
                        right--;
                    }
                }

                if (found) break;
            }
            if (found) break;
        }
    }
}