#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

static vector<vector<int> > A; 
static int K;

void BFS(int city);

int main(void) {
    int N, M, X; cin >> N >> M >> K >> X; A.resize(N + 1);

    // input
    for (int i = 0; i < M; i++) {
        int S, E; cin >> S >> E;
        A[S].push_back(E);
    }

    BFS(X);

    return 0;
}

void BFS(int start) {
    vector<int> distance(A.size(), -1);
    queue<int> q;

    q.push(start);
    distance[start] = 0;

    while (!q.empty()) {
        int city = q.front();
        q.pop();

        for (int next_city : A[city]) {
            if (distance[next_city] == -1) {
                distance[next_city] = distance[city] + 1;
                q.push(next_city);
            }
        }
    }

    bool found = false;
    for (int i = 1; i < distance.size(); i++) {
        if (distance[i] == K) {
            cout << i << "\n";
            found = true;
        }
    }
    if (!found) {
        cout << "-1\n";
    }
}