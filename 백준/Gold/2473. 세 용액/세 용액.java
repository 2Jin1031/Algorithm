import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Long> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(list);

        long globalMinAbs = Long.MAX_VALUE;
        long[] resultArr = new long[3];
        for (int i = 0; i < N; i++) {
            long[] findIdxArr = binarySearch(i);
            if (findIdxArr[0] < globalMinAbs) {
                globalMinAbs = findIdxArr[0];
                resultArr[0] = list.get(i);
                resultArr[1] = list.get((int) findIdxArr[1]);
                resultArr[2] = list.get((int) findIdxArr[2]);
            }
        }

        long[] array = Arrays.stream(resultArr).sorted().toArray();

        System.out.println(array[0] + " " + array[1] + " " + array[2]);
    }

    private static long[] binarySearch(int i) {
        int start = i + 1;
        int end = list.size() - 1;
        long minAbs = Long.MAX_VALUE;
        long[] resultArr = new long[3]; resultArr[0] = Long.MAX_VALUE;
        long absValue;

        while (start < end) {
            long sum = list.get(i) + list.get(start) + list.get(end);
            absValue = Math.abs(sum);

            if (absValue < minAbs) {
                minAbs = absValue;
                resultArr[0] = absValue;
                resultArr[1] = start;
                resultArr[2] = end;
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