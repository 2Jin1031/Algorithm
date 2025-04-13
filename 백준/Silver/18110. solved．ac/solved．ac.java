import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int excludeNum = (int) (N * 0.15 + 0.5);

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr.add(value);
        }

        Collections.sort(arr);
        arr = arr.subList(excludeNum, arr.size() - excludeNum);

        int sum = 0;
        for (int value : arr) {
            sum += value;
        }

        int ans = (int) ((double) sum / arr.size() + 0.5);
        System.out.println(ans);
    }
}
