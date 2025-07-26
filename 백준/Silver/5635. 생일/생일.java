import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static int N, K;

    private static int[][] arr;
    private static int upLocationIdx;
    private static int downLocationIdx;
    
    private static int robotMaxNumber = 1;
    private static int count = 0; // 내구도가 0인 벨트의 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();
        for (int loop = 0; loop < N; loop++) {
            String[] inputs = br.readLine().split(" ");
            String name = inputs[0];

            String birth = "";
            for (int i = 3; i > 0; i--) {
                inputs[i] = inputs[i].length() == 1 ? "0" + inputs[i] : inputs[i];
                birth += inputs[i];
            }

            map.put(name, birth);
        }

        String mostOldName = "";
        String mostOldBirth = "20110101";
        String mostYoungName = "";
        String mostYoungBirth = "19890101";

        for (String currentName : map.keySet()) {
            String currentBirth = map.get(currentName);
            if (mostOldBirth.compareTo(currentBirth) > 0) {
                mostOldName = currentName;
                mostOldBirth = currentBirth;
            }
            if (mostYoungBirth.compareTo(currentBirth) < 0) {
                mostYoungName = currentName;
                mostYoungBirth = currentBirth;
            }
        }

        System.out.println(mostYoungName);
        System.out.println(mostOldName);
    }
}