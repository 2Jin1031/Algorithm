import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();

        int value = N;
        int idx = -1;
        while (true) {
            value = (value * N) % P;
            if (arr.contains(value)) { // 시간 복잡도: O(1)
                idx = arr.indexOf(value);
                break;
            }
            arr.add(value);
        }
        System.out.println(arr.size() - idx);
    }
}