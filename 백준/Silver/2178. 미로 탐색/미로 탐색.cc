#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>

using namespace std;

static int A[101][101];
static bool visited[101][101] = {false};
static int N;
static int M;

static int dx[] = {0, 1, 0, -1};
static int dy[] = {1, 0, -1, 0};

void BFS(int i, int j);

int main(void) {
    N, M; cin >> N >> M;

    // Input
    for (int i = 0; i < N; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < M; j++) {
            A[i][j] = s[j] - '0';
        }
    }

    // Main
    BFS(0, 0);
    cout << A[N-1][M-1];
}

void BFS(int i, int j) {
    queue<pair<int, int> > myQueue;
    myQueue.push(make_pair(i, j));

    while (!myQueue.empty()) {
        int now[2];
        now[0] = myQueue.front().first;
        now[1] = myQueue.front().second;
        myQueue.pop();
        visited[now[0]][now[1]] = true;

        for (int k = 0; k < 4; k++) {
            int x = now[0] + dx[k];
            int y = now[1] + dy[k];

            if (x >= 0 && y >= 0 && x < N && y < M) {
                if (A[x][y] != 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    A[x][y] = A[now[0]][now[1]] + 1;
                    myQueue.push(make_pair(x, y));
                }
            }
        }
    }
}

