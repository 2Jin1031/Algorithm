import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    private static HashSet<String> set;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        set = new HashSet<>();
        while (true) {
            String input = br.readLine();
            if (input.equals("*")) {
                break;
            }
            boolean flag = true;
            int length = input.length();
            int idxDistance;
            for (idxDistance = 1; idxDistance < length; idxDistance++) { // 쌍 변화
                set.clear();
                for (int startIdx = 0; startIdx < length; startIdx++) {
                    int lastIdx = startIdx + idxDistance;
                    if (lastIdx < length) {
                        makePair(input, startIdx, lastIdx);
                    }
                }
                if (!changeFlag(input, idxDistance)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                bw.write(input + " is NOT surprising.\n");
            } else {
                bw.write(input + " is surprising.\n");
            }
        }
        bw.close();
        br.close();
    }

    private static void makePair(String input, int firstLetterIdx, int lastLetterIdx) {
        String newLetters = "" + input.charAt(firstLetterIdx) + input.charAt(lastLetterIdx);
        set.add(newLetters);

    }

    private static boolean changeFlag(String input, int idxDistance) {
        int expectedPairSize = input.length() - idxDistance;
        if (expectedPairSize != set.size()) {
            return false;
        }
        return true;
    }
}