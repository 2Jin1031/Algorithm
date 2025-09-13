import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] g = new char[N][N];
        for (int i = 0; i < N; i++) g[i] = br.readLine().toCharArray();

        int headR = -1, headC = -1;
        boolean found = false;
        for (int r = 0; r < N && !found; r++) {
            for (int c = 0; c < N; c++) {
                if (g[r][c] == '*') { headR = r; headC = c; found = true; break; }
            }
        }

        int heartR = headR + 1;
        int heartC = headC;

        int leftArm = 0;
        for (int c = heartC - 1; c >= 0 && g[heartR][c] == '*'; c--) leftArm++;

        int rightArm = 0;
        for (int c = heartC + 1; c < N && g[heartR][c] == '*'; c++) rightArm++;

        int waist = 0;
        int r = heartR + 1;
        while (r < N && g[r][heartC] == '*') { waist++; r++; }
        int waistEndR = heartR + waist;

        int leftLeg = 0;
        r = waistEndR + 1;
        int lc = heartC - 1;
        while (r < N && lc >= 0 && g[r][lc] == '*') { leftLeg++; r++; }

        int rightLeg = 0;
        r = waistEndR + 1;
        int rc = heartC + 1;
        while (r < N && rc < N && g[r][rc] == '*') { rightLeg++; r++; } // ← 세미콜론 제거

        StringBuilder sb = new StringBuilder();
        sb.append(heartR + 1).append(' ').append(heartC + 1).append('\n');
        sb.append(leftArm).append(' ')
          .append(rightArm).append(' ')
          .append(waist).append(' ')
          .append(leftLeg).append(' ')
          .append(rightLeg);
        System.out.println(sb.toString());
    }
}