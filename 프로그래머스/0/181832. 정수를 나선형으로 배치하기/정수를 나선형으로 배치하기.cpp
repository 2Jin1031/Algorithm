#include <iostream>
#include <vector>
using namespace std;

int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};

bool isCoordinate(int i, int j, int n, const vector<vector<int>>& answer) {
    if (i < 0 || i >= n || j < 0 || j >= n) return false;
    return answer[i][j] == 0;   // 아직 안 채운 칸이면 true
}

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer(n, vector<int>(n, 0));

    int ii = 0, jj = 0;
    int num = 1;
    int di = 0;

    answer[0][0] = num++;   // 첫 칸에 1, num은 2가 됨

    while (num <= n * n) {
        ii += dx[di];
        jj += dy[di];

        if (!isCoordinate(ii, jj, n, answer)) {
            ii -= dx[di];
            jj -= dy[di];
            di = (di + 1) % 4;
            continue;
        }
        answer[ii][jj] = num++;
    }

    return answer;
}