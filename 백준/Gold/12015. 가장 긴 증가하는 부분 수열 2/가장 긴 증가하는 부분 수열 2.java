import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : arr) {
            if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                lis.add(num);  // 새로운 증가 원소 추가
            } else {
                // lower_bound: 현재 숫자가 들어갈 위치를 이진 탐색으로 찾기
                int pos = lowerBound(lis, num);
                lis.set(pos, num);  // 해당 위치 값 갱신
            }
        }

        System.out.println(lis.size());  // LIS의 길이 출력
    }

    // lowerBound 구현 (이진 탐색)
    private static int lowerBound(ArrayList<Integer> list, int key) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}