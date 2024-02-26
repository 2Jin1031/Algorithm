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
void DFS(int v);

int main(void) {
    int N, M; scanf("%d %d", &N, &M);
    A = vector<vector<int> > (N + 1);
    visited = vector<bool>(N + 1, false);

    for (int i = 0; i < M; i++) {
        int a, b; scanf("%d %d", &a, &b);
        A[a].push_back(b);
        A[b].push_back(a);
    }

    // DFS
    int count = 0;
    for (int i = 1; i < N + 1; i++) {
        if(!visited[i]) {
            DFS(i);
            count++;
        }
    }
    printf("%d", count);
    
    return 0;
}

void DFS(int v) {
    if (visited[v]) {
        return ;
    }
    visited[v] = true;

    for (int i : A[v]) {
        if (!visited[i]) {
            DFS(i);
        }
    }
}
