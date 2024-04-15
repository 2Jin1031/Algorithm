#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>


// 1026
using namespace std;

static int N;
static int M;
static vector<int> V;

void DFS(int num, int depth, vector<int> &combination);

int main(void) {
    scanf("%d  %d", &N, &M);

    DFS(1, 0, V);
}

void DFS(int num, int depth, vector<int> &combination) {
    if (depth == M) {
        for (int num : combination) {
            printf("%d ", num);
        }
        printf("\n");
        return ;
    }
    
    for (int i = num; i <= N; i++) {
        combination.push_back(i);
        DFS(i, depth + 1, combination);
        combination.pop_back();
    }
}