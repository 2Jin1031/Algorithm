import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final Character[] PATTERN = {'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        List<Character> voice = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            voice.add(ch);
        }

        boolean[] isUsed = new boolean[voice.size()];
        PriorityQueue<Integer> duckEndTimes = new PriorityQueue<>();

        List<Character> current = new ArrayList<>(voice);
        int realIndex = 0;

        while (true) {
            int firstIdx;
            // 다음 사용되지 않은 'q' 찾기
            while (true) {
                firstIdx = current.indexOf('q');
                if (firstIdx == -1) break;

                realIndex += firstIdx;
                if (!isUsed[realIndex]) {
                    current = current.subList(firstIdx, current.size());
                    break;
                }
                current = current.subList(firstIdx + 1, current.size());
                realIndex++;
            }

            if (firstIdx == -1) break;

            // 사용 가능한 오리 있으면 꺼내기
            if (!duckEndTimes.isEmpty() && duckEndTimes.peek() <= realIndex) {
                duckEndTimes.poll();
            }

            int endIdx = findQuack(realIndex, current, isUsed);
            if (endIdx == -1) {
                System.out.println("-1");
                return;
            }

            duckEndTimes.add(endIdx);
        }

        // 사용 안 된 문자가 있으면 실패
        for (boolean used : isUsed) {
            if (!used) {
                System.out.println("-1");
                return;
            }
        }

        System.out.println(duckEndTimes.size());
    }

    private static int findQuack(int baseIdx, List<Character> list, boolean[] isUsed) {
        int[] positions = new int[5];
        int localBase = baseIdx;
        List<Character> subList = new ArrayList<>(list);

        for (int i = 0; i < PATTERN.length; i++) {
            while (true) {
                int idx = subList.indexOf(PATTERN[i]);
                if (idx == -1) return -1;

                int realIdx = localBase + idx;
                if (!isUsed[realIdx]) {
                    isUsed[realIdx] = true;
                    positions[i] = realIdx;
                    break;
                }

                subList = subList.subList(idx + 1, subList.size());
                localBase = realIdx + 1;
            }
        }

        // 순서 확인
        for (int i = 1; i < positions.length; i++) {
            if (positions[i - 1] >= positions[i]) {
                return -1;
            }
        }

        return positions[4] + 1; // 마지막 'k' 다음 인덱스
    }
}