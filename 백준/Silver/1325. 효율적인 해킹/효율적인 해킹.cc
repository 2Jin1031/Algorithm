#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

// 1325

static vector<vector<int> > A; 
vector<int> result;


int BFS(int start);

int main(void) {
    int N, M; cin >> N >> M; A.resize(N + 1); result.resize(N + 1, 0);
    for (int i = 0; i < M; i++) {
        int a, b; cin >> a >> b;
        A[b].push_back(a);
    }

    // logic
    for (int i = 1; i < A.size(); i++) {
        BFS(i);
    }

    // print
    int max_result = *max_element(result.begin(), result.end());
    for (int i = 1; i <= N; i++) {
        if (result[i] == max_result) {
            cout << i << " ";
        }
    }

    return 0;
}

int BFS(int start) {
    vector<bool> visited(A.size(), false);
    queue<int> q;
    int count = 0;

    q.push(start);
    visited[start] = true;

    while (!q.empty()) {
        int cpt = q.front();
        q.pop();
        count++;

        for (int ccpt : A[cpt]) {
            if (!visited[ccpt]) {
                q.push(ccpt);
                visited[ccpt] = true;
            }
        }
    }

    result[start] = count;
    return count;
}