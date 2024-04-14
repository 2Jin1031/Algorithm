#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>


// 15650
using namespace std;

static int N;
static int M;
static bool flag = false;

void DFS(int start, int depth, vector<int> &combination);

int main(void) {
    scanf("%d %d", &N, &M);

    vector<int> combination;
    DFS(1, 0, combination);
    return 0;
}

void DFS(int start, int depth, vector<int> &combination) {
    if (depth == M) {
        for (int num : combination) 
            printf("%d ", num);
        printf("\n");
        return ;
    }
    
    for (int i = start; i <= N; i++) {
        combination.push_back(i);
        DFS(i + 1, depth + 1, combination);
        combination.pop_back();
    }
}