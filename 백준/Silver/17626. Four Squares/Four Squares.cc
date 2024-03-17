#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>
#include <cmath>

using namespace std;

const int MAXN = 50001;
int dp[MAXN];

int main(void) {
    int N;
    cin >> N;

    for (int i = 0; i <= N; i++) {
        dp[i] = i;
        for (int j = 1; j * j <= i; j++) {
            dp[i] = min(dp[i], dp[i - j * j] + 1);
        }
    }

    cout << dp[N] << endl;
    return 0;
}