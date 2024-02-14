#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;
static vector<vector<int> > A;
static vector<int> visited;
int DFS(int v, int order);

int main(void) {
    int N, M, R; cin >> N >> M >> R;
    A = vector<vector<int> >(N + 1);
    visited = vector<int>(N + 1, 0);

    // 초기화
    for (int i = 1; i < N + 1; i++) {
        A[i].push_back(i);
    }

    // Input
    for (int i = 0; i < M; i++) {
        int a, b; cin >> a >> b;
        A[a].push_back(b);
        A[b].push_back(a);
    }

    // Sort
    for (int i = 1; i <= N; i++) {
        if (A[i].size() >= 3) sort(A[i].begin() + 1, A[i].end());
    }

    // Main
    int a = DFS(A[R].front(), 1);

    // Print
    for (int i = 1; i <= N; i++) {
        cout << visited[i] << "\n";
    }

    return 0;
}

int DFS(int v, int order) {
    if (visited[v]) {
        return order;
    }
    visited[v] = order;

    for (int i : A[v]) {
        if (!visited[i]) {
            order = DFS(i, ++order);
        }
    }
    return order;
}