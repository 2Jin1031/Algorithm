import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            }

            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                int left = 0;
                int right = list.size() - 1;
                boolean isExist = false;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) == num) {
                        isExist = true;
                        break;
                    } else if (list.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                bw.write(isExist ? "1\n" : "0\n");
            }
        }

        bw.close();
        br.close();
    }
}