import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Main {

    private static Character[] src;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        src = new Character[]{'q', 'u', 'a', 'c', 'k'};

        String input = br.readLine();

        List<Character> voice = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            voice.add(input.charAt(i));
        }
        boolean[] isUsed = new boolean[voice.size()];

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // idx부터 울음을 시작할 수 있는 준비된 덕들

        List<Character> tmp = new ArrayList<>(voice);

        int realIdx = 0;
        int lastCanNewStartIdx = 0;
        while (true) {
            int firstIdx;
            while (true) {
                firstIdx = tmp.indexOf(src[0]);
                if (firstIdx == -1) {
                    break;
                }
                realIdx += firstIdx;
                if (!isUsed[realIdx]) { // 만약 아직 사용 안한 거 찾았으면 나가기
                    tmp = tmp.subList(firstIdx, tmp.size());
                    break;
                }
                tmp = tmp.subList(firstIdx + 1, tmp.size()); // 사용 안한 값을 찾기 위해 계속 뒤로 가기
                realIdx++;
            }
            if (firstIdx == -1) {
                break;
            }

            if (!pq.isEmpty() && pq.peek() <= realIdx) { // 소리를 낼 수 있는 오리가 존재하면
                pq.poll(); // 사용중 표시를 한다
            }


            int canNewStartIdx = findVoiceBlock(realIdx, tmp, isUsed);
            if (canNewStartIdx == -1) {
                System.out.println("-1");
                return;
            } else {
                lastCanNewStartIdx = canNewStartIdx;
                pq.add(canNewStartIdx);
            }
        }

        if (pq.size() == 1 && pq.peek() == -1) {
            System.out.println("-1");
        } else {

            List<Boolean> list = new ArrayList<>();
            for (boolean b : isUsed) {
                list.add(b);
            }
            if (list.contains(Boolean.FALSE)) {
                System.out.println("-1");
            } else {
                System.out.println(pq.size());
            }
        }
    }

    private static int findVoiceBlock(int disapearAmount, List<Character> tmp, boolean[] isUsed) {
        int[] idxDB = new int[5];
        for (int i = 0; i < src.length; i++) {
            int findIdx;
            List<Character> ttmp = new ArrayList<>(tmp);
            int localDisappearAmount = disapearAmount;
            while (true) {
                findIdx = ttmp.indexOf(src[i]);
                if (findIdx == -1) { // 못 찾았으면 울음소리 완성 불가 표시 반환
                    return -1;
                }
                int realIdx = localDisappearAmount + findIdx;
                if (!isUsed[realIdx]) { // 만약 아직 사용 안한 거 찾았으면 사용 표시 하고 나가기
                    isUsed[realIdx] = true;
                    idxDB[i] = realIdx;
                    break;
                }
                ttmp = ttmp.subList(findIdx + 1, ttmp.size());
                localDisappearAmount = realIdx + 1;
            }
        }

        for (int i = 1; i < idxDB.length; i++) {
            if (idxDB[i - 1] >= idxDB[i]) {
                return -1;
            }
        }

        return idxDB[4] + 1;
    }
}
