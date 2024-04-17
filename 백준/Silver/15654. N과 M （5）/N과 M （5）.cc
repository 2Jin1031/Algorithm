#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>


// 15654
using namespace std;

static int N;
static int M;
static vector<int> V;
static vector<bool> D;

void DFS(int num, int depth, vector<int> &combination);

int main(void) {
    scanf("%d  %d", &N, &M); V.resize(N); D.resize(N, true);
    for (int i = 0; i < N; i++) {
        cin >> V[i];
    }

    sort(V.begin(), V.end());

    vector<int> combination;
    DFS(0, 0, combination);
}

void DFS(int num, int depth, vector<int> &combination) {
    if (depth == M) {
        for (int num : combination) {
            printf("%d ", num);
        }
        printf("\n");
        return ;
    }
    
    for (int i = 0; i < N; i++) {
        if (!D[i]) continue;
        combination.push_back(V[i]);
        D[i] = false;
        DFS(i, depth + 1, combination);
        combination.pop_back();
        D[i] = true;
    }
}