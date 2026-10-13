import java.util.*;

class Solution {
    int m, n, h, w;
    int[][] map;

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        this.m = m; this.n = n; this.h = h; this.w = w;

        // map[x][y] = 처음 비 맞은 순서 (안 맞으면 MAX)
        map = new int[m][n];
        for (int r = 0; r < m; r++) Arrays.fill(map[r], Integer.MAX_VALUE);
        for (int i = 0; i < drops.length; i++) {
            int x = drops[i][0], y = drops[i][1];
            if (map[x][y] == Integer.MAX_VALUE) map[x][y] = i + 1;
        }

        // 마른 영역이 존재하는 가장 큰 t 찾기 (t = 0이면 항상 존재)
        int lo = 0, hi = drops.length;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (findDry(mid) != null) lo = mid;
            else hi = mid - 1;
        }
        return findDry(lo);
    }

    // t번째 빗방울까지 떨어졌을 때, 마른 h×w 영역의 좌상단 (행→열 순 첫 번째), 없으면 null
    int[] findDry(int t) {
        int[][] ps = new int[m + 1][n + 1];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int wet = map[r][c] <= t ? 1 : 0;
                ps[r + 1][c + 1] = wet + ps[r][c + 1] + ps[r + 1][c] - ps[r][c];
            }
        }
        for (int r = 0; r <= m - h; r++) {
            for (int c = 0; c <= n - w; c++) {
                int cnt = ps[r + h][c + w] - ps[r][c + w] - ps[r + h][c] + ps[r][c];
                if (cnt == 0) return new int[]{r, c};
            }
        }
        return null;
    }
}