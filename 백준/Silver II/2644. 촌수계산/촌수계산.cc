#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>

using namespace std;

static vector<vector<int> > A;
static vector<bool> visited;
static int a, b;
static int flag;
static int result;

void DFS(int v, int pcount);

int main(void) {
    int N;
    cin >> N;
    cin >> a >> b;
    int M;
    cin >> M;

    A = vector<vector<int> >(N + 1);
    visited = vector<bool>(N + 1, false);

    // 초기화
    for (int i = 0; i < N + 1; i++) {
        A[i].push_back(i);
    }

    // Input
    for (int i = 0; i < M; i++) {
        int x, y;
        cin >> x >> y;
        A[x].push_back(y);
        A[y].push_back(x);
    }

    // Main
    int count = 1;
    flag = 0;
    DFS(A[a].front(), count);
    count = result;

    //Print
    if (!flag) count = -1;
    cout << count;
}

void DFS(int v, int count) {
    if (flag || visited[v]) {
        return;
    }
    visited[v] = true;
    int tmp = count;
    for (int i : A[v]) {
        if (flag == 1) {
            break;
        }
        if (i == b) {
            flag = 1;
            result = count;
            break;
        }
        if (!visited[i]) {
            DFS(i, tmp + 1);
        }
    }
    return;
}