import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, K;
    private static int[] arr;
    private static List<String> ans = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }

        K = set.size();
        arr = new int[K];
        int ii = 0;
        for (int value : set) {
            arr[ii++] = value;
        }
        Arrays.sort(arr);

        backtracking("", 0);  

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    private static void backtracking(String str, int depth) {
        if (depth == M) {
            ans.add(str);
            return ;
        }
        
        for (int i = 0; i < K; i++) {
            backtracking(str + (arr[i]) + " ", depth + 1);
        }
    }
}