import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>();
        HashMap<String, Integer> order = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            set.add(input);
            order.put(input, i); // 입력된 순서 저장
        }

        String[] list = set.toArray(new String[0]);
        int maxLength = 0;
        String result1 = "";
        String result2 = "";
        int result1Idx = 0;
        int result2Idx = 0;

        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                String s1 = list[i];
                String s2 = list[j];

                int s1Idx = order.get(s1);
                int s2Idx = order.get(s2);

                if (s1Idx > s2Idx) {
                    String temp = s1;
                    s1 = s2;
                    s2 = temp;
                    int tempIdx = s1Idx;
                    s1Idx = s2Idx;
                    s2Idx = tempIdx;
                }


                // 공통 접두사 길이 계산
                int commonLength = commonPrefixLength(s1, s2);

                // 공통 접두사 길이가 짧아지면 break
                if (commonLength < maxLength) {
                    break;
                }

                // 결과 갱신 조건
                if (commonLength > maxLength) {
                    maxLength = commonLength;
                    result1 = s1;
                    result2 = s2;
                    result1Idx = s1Idx;
                    result2Idx = s2Idx;
                } else if (commonLength == maxLength) {
                    // 입력 순서 기준으로 더 작은 결과 선택
                    if (s1Idx < result1Idx || (s1Idx == result1Idx && s2Idx < result2Idx)) {
                        result1 = s1;
                        result2 = s2;
                        result1Idx = s1Idx;
                        result2Idx = s2Idx;
                    }
                }
            }
        }

        System.out.println(result1);
        System.out.println(result2);
    }

    public static int commonPrefixLength(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int index = 0;

        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            index++;
        }

        return index;
    }
}