#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>

// 15663

using namespace std;

static int N;
static int M;
static vector<int> A;
static vector<bool> D;

void DFS(int depth, vector<int> &combination);

int main(void) {
    cin >> N >> M; A.resize(N); D.resize(N, false);
    for (int i = 0; i < N; i++) cin >> A[i];

    sort(A.begin(), A.end());

    vector<int> combination;
    DFS(0, combination);
}

void DFS(int depth, vector<int> &combination) {
    if (depth == M) {
        for (int v : combination) cout << v << " ";
        cout << "\n";
        return ;
    }

    for (int i = 0; i < A.size(); i++) {
       if (D[i] || (i > 0 && A[i] == A[i - 1] && !D[i - 1])) continue;
        combination.push_back(A[i]);
        D[i] = true;
        DFS(depth + 1, combination);
        D[i] = false;
        combination.pop_back();
    }

    
}