import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeMap<int[], String> map = new TreeMap<>(Comparator.comparingInt((int[] arr) -> arr[1])
                                                  .thenComparing(arr -> arr[0]));
        for (int loop = 0; loop < M; loop++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            map.put(new int[]{a, b}, str);
        }

        for (int[] arr : map.keySet()) {
            String str = map.get(arr);
            System.out.printf(str);
        }
    }
}