#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>

// #14940

using namespace std;

static int N;
static int M;
static vector<vector<int> > A;
static vector<vector<int> > D;

int main(void) {
    scanf("%d %d", &N, &M);
    A.resize(N, vector<int>(M));
    D.resize(N, vector<int>(M, -1));

    // input
    queue<pair<int, int> > q;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            scanf("%d", &A[i][j]);
            if (A[i][j] == 2) {
                q.push(pair<int, int> (i, j));
                D[i][j] = 0;
            }
            if (A[i][j] == 0) D[i][j] = 0;
        }
    }

    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && A[nx][ny] == 1 && D[nx][ny] == -1) {
                D[nx][ny] = D[x][y] + 1;
                q.push(pair<int, int> (nx, ny));
            }
        }
    }

    // print
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            printf("%d ", D[i][j]);
        }
        printf("\n");
    }
}