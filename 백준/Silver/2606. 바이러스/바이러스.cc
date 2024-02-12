#include <string>
#include <vector>
#include <cstring>
#include <iostream>

using namespace std;
static int N;
static int M;
static vector<bool> visited;
static vector<vector<int> > A;
int DFS(int v, int count);

int main(void) {
    cin >> N >> M;
    A = vector<vector<int> >(N + 1);
    visited = vector<bool>(N + 1, false);
    for (int i = 0; i < M; i++) {
        int a, b; cin >> a >> b;
        A[a].push_back(b);
        A[b].push_back(a);
    }
    int count = 0;
    if (!A[1].empty()) count = DFS(A[1].front(), 0);
    cout << count;
}

int DFS(int v, int count) {
    if (visited[v]) {
        return count;
    }

    visited[v] = true;

    for (int i : A[v]) {
        if (visited[i] == false) {
            count++;
            count = DFS(i, count);
        }
    }
    return count;
}