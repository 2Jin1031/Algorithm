import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;

    private static int[][] map;

    private static List<int[]> housePositions;
    private static List<int[]> chickenPositions;

    private static int[][] distanceMap;
    private static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        housePositions = new ArrayList<>();
        chickenPositions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    housePositions.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickenPositions.add(new int[]{i, j});
                }
            }
        }

        distanceMap = new int[housePositions.size()][chickenPositions.size()];
        for (int i = 0; i < housePositions.size(); i++) {
            for (int j = 0; j < chickenPositions.size(); j++) {
                int[] housePosition = housePositions.get(i);
                int[] chickenPosition = chickenPositions.get(j);
                distanceMap[i][j] = Math.abs(housePosition[0] - chickenPosition[0]) + Math.abs(
                        housePosition[1] - chickenPosition[1]);
            }
        }

        placeChickens(0, 0, new ArrayList<>());

        System.out.println(minResult);
    }

    private static void placeChickens(int index, int start, ArrayList<Integer> selectedChickenColumns) {
        if (index == M) {
            int sum = 0;
            for (int i = 0; i < housePositions.size(); i++) {
                int minDistance = Integer.MAX_VALUE;
                for (Integer column : selectedChickenColumns) {
                    minDistance = Math.min(minDistance, distanceMap[i][column]);
                }
                sum += minDistance;
            }
            minResult = Math.min(minResult, sum);
            return ;
        }

        for (int i = start; i < chickenPositions.size(); i++) {
            selectedChickenColumns.add(i);
            placeChickens(index + 1, i + 1, selectedChickenColumns);
            selectedChickenColumns.remove(selectedChickenColumns.size() - 1);
        }
    }
}