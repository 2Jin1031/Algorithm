#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>

using namespace std;

static vector<vector<int> > A;
static vector<bool> visited;
static bool arrive;

void DFS(int v, int depth);

int main(void) {
    int N, M; cin >> N >> M;
    A = vector<vector<int> >(N);
    visited = vector<bool>(N, false);

    for(int i = 0; i < M; i++) {
        int a, b; cin >> a >> b;
        A[a].push_back(b);
        A[b].push_back(a);
    }

    for(int i = 0; i < N; i++) {
        DFS(i, 1);
        if (arrive) {
            cout << "1";
            return 0;
        }
    }

    cout << "0";
    return 0;
}

void DFS(int v, int depth) {
    if (depth == 5 || arrive) {
        arrive = true;
        return;
    }

    visited[v] = true;

    for (int i : A[v]) {
        if (!visited[i])
            DFS(i, depth + 1);
    }
    visited[v] = false;
}

