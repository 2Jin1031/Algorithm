#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>

using namespace std;

static int N;

static int dp[1001] = {0};

int ft_dp(int num) {
    if (dp[num]) return dp[num];

    dp[num] = (ft_dp(num - 1) + ft_dp(num - 2) * 2) % 10007;
    return dp[num];
}

int main(void) {
    scanf("%d", &N);

    dp[1] = 1; dp[2] = 3;
    printf("%d", ft_dp(N));
}