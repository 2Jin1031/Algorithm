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
static int flag;

void DFS(int v, int count);

int main(void) {
    scanf("%d %d", &N, &M);

    A = vector<vector<int> >(N);
    visited = vector<bool> (N, false);

    for (int i = 0; i < M; i++) {
        int a, b; scanf("%d %d", &a, &b);
        A[a].push_back(b);
        A[b].push_back(a);
    }

    for (int i = 0; i < N; i++) {
        fill(visited.begin(), visited.end(), false);
        flag = 0;
        DFS(i, 1);
        if (flag) {
            printf("1");
            return 0;
        }
    }

    printf("0");
    return 0;
}

void DFS(int v, int count) {
    if (count == 5 || flag == 1) {
        flag = 1;
        return ;
    }

    visited[v] = true;

    for (int i : A[v]) {
        if (!visited[i]) {
            DFS(i, count + 1);
        }
        
    }

    visited[v] = false;
}