#include <iostream>
#include <locale>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

// 10974

static int N;
static vector<int> v;
static vector<bool> visited;

void DFS(int num, int depth, vector<int> &vec);

int main(void) {
    cin >> N; visited.resize(N + 1, false);
        vector<int> vec;
        DFS(1, 0, vec);
}

void DFS(int num, int depth, vector<int> &vec) {
    if (depth == N) {
        for (int x : vec) {
            cout << x << " ";
        }
        cout << "\n";
    }

    for (int i = 1; i < N + 1; i++) {
        if (!visited[i]) {
            vec.push_back(i);
            visited[i] = true;
            DFS(i, depth + 1, vec);
            vec.pop_back();
            visited[i] = false;
        }
    }
}