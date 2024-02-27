#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;
static vector<vector<int> > A;
static vector<bool> visited;
static int N, M;

void DFS(int v);
void BFS(int v);

int main(void) {
    int V; scanf("%d %d %d", &N, &M, &V);

    A = vector<vector<int> >(N + 1);
    visited = vector<bool> (N + 1, false);

    for (int i = 0; i < M; i++) {
        int a, b; scanf("%d %d", &a, &b);
        A[a].push_back(b);
        A[b].push_back(a);
    }

    for (int i = 1; i < N + 1; i++) {
        sort(A[i].begin(), A[i].end());
    }

    DFS(V); printf("\n");
    fill(visited.begin(), visited.end(), false);
    BFS(V);
}

void DFS(int v) {
    printf("%d ", v);
    visited[v] = true;

    for (int i : A[v]) {
        if (!visited[i]) {
            DFS(i);
        }
    }
}

void BFS(int v) {
    queue<int> myQueue;
    myQueue.push(v); visited[v] = true;
    
    while (!myQueue.empty()) {
        int now = myQueue.front();
        myQueue.pop();
        printf("%d ", now);
        for (int i : A[now]) {
            if (!visited[i]) {
                myQueue.push(i);
                visited[i] = true;
            }
        }
    }
}