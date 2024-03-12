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

static int N;
static vector<int> A;
static int sum;
static vector<bool> C; // true: 이미 붙음, false: 안 붙음 
static int result;
static vector<int> dp;

void ft_input() {
    scanf("%d", &N);
    A = vector<int>(N + 1, 0);
    for (int i = 1; i <= N; i++) {
        scanf("%d", &A[i]);
    }
}

void ft_solution() {
    dp = vector<int> (N + 1);
    dp[1] = A[1];
    dp[2] = A[1] + A[2];
    dp[3] = max(A[1] + A[3], A[2] + A[3]);

    for (int i = 4; i <= N; i++) {
        dp[i] = max(dp[i-2] + A[i], dp[i-3] + A[i-1] + A[i]);
    }

    printf("%d", dp[N]);
}

void ft_solve() {
    ft_input();
    ft_solution();
}

int main(void) {
    ft_solve();
    
    return 0;
}