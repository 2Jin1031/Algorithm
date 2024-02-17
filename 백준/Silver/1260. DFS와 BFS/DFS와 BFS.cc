#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>

using namespace std;

static vector<vector<int> > A;
static vector<int> visited;
static bool arrive;

void DFS(int v, int depth);
void BFS(int v, int b);

int main(void) {
    int N, M, V; cin >> N >> M >> V;
    A = vector<vector<int> >(N + 1);
    visited = vector<int>(N + 1);

    for (int i = 0; i < N + 1; i++) {
        A[i].push_back(i);
    }

    // Input
    for (int i = 0; i < M; i++) {
        int a, b; cin >> a >> b;
        A[a].push_back(b);
        A[b].push_back(a);
    }

    // Sort
    for (int i = 0; i < N + 1; i++) {
        sort(A[i].begin() + 1, A[i].end());
    }

    // Main
    DFS(A[V].front(), 1);
    // for (int i = 1; i < N + 1; i++) {
    //     cout << visited[i] << " ";
    // }
    cout << "\n";

    fill(visited.begin(), visited.end(), 0);

    BFS(A[V].front(), 1);
    // for (int i = 1; i < N + 1; i++) {
    //     cout << visited[i] << " ";
    // }
}

void DFS(int v, int depth) {
    if (visited[v]) {
        
    }
    visited[v] = depth;
    cout << v << " ";

    for (int i : A[v]) {
        if (!visited[i]) {
            DFS(i, depth + 1);
        }
    }
}

void BFS(int v, int b) {
    queue<int> myQueue;
    myQueue.push(v);
    
    visited[v] = b;

    while (!myQueue.empty()) {
        int now = myQueue.front();
        cout << now << " ";
        myQueue.pop();
        for (int i : A[now]) {
            if (!visited[i]) {
                visited[i] = (++b);
                myQueue.push(i);
            }
        }
    }
}

