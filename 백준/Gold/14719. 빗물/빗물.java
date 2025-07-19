import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static int H, W;

    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[W];
        visited = new boolean[W];
        st = new StringTokenizer(br.readLine());

        int maxValue = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                maxIdx = i;
            }
        }

        // 왼쪽 List
        List<List<Integer>> leftList = new ArrayList<>();
        for (int i = 0; i < maxIdx; i++) {
            List<Integer> data = new ArrayList<>();
            data.add(i);
            data.add(arr[i]);
            leftList.add(data);
        }

        // 왼쪽 List를 높이로 내림차순하기
        leftList.sort((a, b) -> {
            int cmp = Integer.compare(b.get(1), a.get(1));
            if (cmp == 0) {
                return Integer.compare(b.get(0), a.get(0));
            }
            return cmp;
        });

        // 오른쪽 List
        List<List<Integer>> rightList = new ArrayList<>();
        for (int i = maxIdx + 1; i < W; i++) {
            List<Integer> data = new ArrayList<>();
            data.add(i);
            data.add(arr[i]);
            rightList.add(data);
        }

        // 오른쪽 List를 높이로 내림차순하기
        rightList.sort((a, b) -> {
            int cmp = Integer.compare(b.get(1), a.get(1));
            if (cmp == 0) {
                return Integer.compare(a.get(0), b.get(0));
            }
            return cmp;
        });
        
        int ans = leftBfs(leftList, maxIdx) + rightBfs(rightList, maxIdx);
        System.out.println(ans);
    }

    private static int leftBfs(List<List<Integer>> leftList, int idx) {
        int maxIdx = idx;

        int sum = 0;
        while (!leftList.isEmpty()) {
            List<Integer> list = leftList.get(0);
            int currentIdx = list.get(0);
            if (maxIdx < currentIdx) {
                leftList.remove(0);
                continue;
            }
            if (currentIdx + 1 != maxIdx) {
                sum += makeSum(currentIdx, maxIdx);    
            }

            if (currentIdx == 0) {
                break;
            }
            maxIdx = currentIdx;
            leftList.remove(0);
        }
        return sum;
    }

    private static int rightBfs(List<List<Integer>> rightList, int idx) {
        int minIdx = idx;

        int sum = 0;
        while (!rightList.isEmpty()) {
            List<Integer> list = rightList.get(0);
            int currentIdx = list.get(0);
            if (minIdx > currentIdx) {
                rightList.remove(0);
                continue;
            }

            if (currentIdx - 1 != minIdx) {
                sum += makeSum(minIdx, currentIdx);
            }

            if (currentIdx == W - 1) break;
            minIdx = currentIdx;
            rightList.remove(0);
        }
        return sum;
    }

    private static int makeSum(int minIdx, int maxIdx) {
        int minValue = Math.min(arr[minIdx], arr[maxIdx]);

        int localSum = 0;
        for (int i = minIdx + 1; i < maxIdx; i++) {
            localSum += minValue - arr[i];
        }
        return localSum;
    }
}
