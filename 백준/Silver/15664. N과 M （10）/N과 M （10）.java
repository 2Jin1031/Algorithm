import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);

        Set<String> ans = backtracking("", 0, 0);

        

        for (String sb : ans) {
            System.out.printf(sb);    
        }
    }

    private static Set<String> backtracking(String str, int idx, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            Set<String> set = new LinkedHashSet<>();
            set.add(str + "\n");
            return set;
        }

        Set<String> totalSet = new LinkedHashSet<>();
        for (int i = idx; i < N; i++) {
            Set<String> localSb = backtracking(str + (arr[i]) + " ", i + 1, depth + 1);
            totalSet.addAll(localSb);
        }

        return totalSet;
    }
}