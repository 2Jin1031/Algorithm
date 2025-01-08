import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int[] result = binarySearch();
        System.out.println(list.get(result[0]) + " " + list.get(result[1]));
    }

    private static int[] binarySearch() {
        int start = 0;
        int end = list.size() - 1;
        int minAbs = Integer.MAX_VALUE;
        int[] resultArr = new int[2];
        int absValue;

        while (start < end) {
            int sum = list.get(start) + list.get(end);
            absValue = Math.abs(sum);

            if (absValue < minAbs) {
                minAbs = absValue;
                resultArr[0] = start;
                resultArr[1] = end;
            }
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        return resultArr;
    }
}