#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <string>
#include <cmath>

using namespace std;

static vector<vector<int> > graph;
static vector<int> check;
static vector<bool> visited;
static bool IsEven;

void DFS(int node);

int main(void) {
    int K; cin >> K;
    for (int i = 0; i < K; i++) {
        int V, E; cin >> V >> E;
        graph.resize(V + 1); graph[0].push_back(-1);
        visited.resize(V + 1);
        check.resize(V + 1);
        IsEven = true;
        for (int j = 0; j < E; j++) {
            int a, b; cin >> a >> b;
            graph[a].push_back(b);
            graph[b].push_back(a);
        }
        for (int i = 1; i <= V; i++) {
            if(IsEven) {
                DFS(i);
            }
            else {
                break;
            }
        }
        if (IsEven) {
            cout << "YES" << "\n";
        }
        else {
            cout << "NO" << "\n";
        }
        for (int i = 0; i < V + 1; i++) {
            graph.clear();
            visited[i] = false;
            check[i] = 0;
        }
    }
}

void DFS(int node) {
    visited[node] = true;

    for (int i : graph[node]) {
        if(!visited[i]) {
            check[i] = (check[node] + 1) % 2;
            DFS(i);
        }
        else if (check[node] == check[i]) {
            IsEven = false;
        }
    }
}