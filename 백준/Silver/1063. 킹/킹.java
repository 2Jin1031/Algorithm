import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    private static final int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    private static final int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingPositionStr = st.nextToken();
        String rockPositionStr = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[9][9];
        int[] kingPosition = convertToPosition(kingPositionStr);
        int[] rockPosition = convertToPosition(rockPositionStr);

        for (int i = 0; i < N; i++) {
            String moveCode = br.readLine();
            int di = switch (moveCode) {
                case "R"  -> 0;
                case "T"  -> 1;
                case "L"  -> 2;
                case "B"  -> 3;
                case "RT" -> 4;
                case "LB" -> 5;
                case "RB" -> 6;
                case "LT" -> 7;
                default   -> throw new IllegalArgumentException("Unknown move: " + moveCode);
            };
            move(kingPosition, rockPosition, di);
        }

        System.out.println(convertToStr(kingPosition));
        System.out.println(convertToStr(rockPosition));
    }

    private static int[] convertToPosition(String input) {
        int x = input.charAt(0) - 'A' + 1;
        int y = Integer.parseInt(input.charAt(1) + "");
        return new int[]{x, y};
    }

    private static void move(int[] kingPosition, int[] rockPosition, int di) {
        int nextX = kingPosition[0] + dx[di];
        int nextY = kingPosition[1] + dy[di];

        int nextRockX = rockPosition[0];
        int nextRockY = rockPosition[1];
        if (rockPosition[0] == nextX && rockPosition[1] == nextY) {
            nextRockX = rockPosition[0] + dx[di];
            nextRockY = rockPosition[1] + dy[di];
        }

        if (isValidCoordinate(nextX, nextY) && isValidCoordinate(nextRockX, nextRockY)) {
            kingPosition[0] = nextX;
            kingPosition[1] = nextY;

            rockPosition[0] = nextRockX;
            rockPosition[1] = nextRockY;
        }
        
    }

    private static boolean isValidCoordinate(int nextX, int nextY) {
        return nextX >= 1 && nextX < 9 && nextY >= 1 && nextY < 9;
    }

    private static String convertToStr(int[] position) {
        String ans = "";
        Character chX = (char) (position[0] - 1 + 'A');
        ans += chX + "" + position[1];
        return ans;
    }
}
