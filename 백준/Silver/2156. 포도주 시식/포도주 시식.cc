#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <string>
#include <cmath>

using namespace std;

static vector<int> wine;
static vector<int> dp;

int main(void) {
    int N; cin >> N; wine.resize(N + 1); dp.resize(N + 1);

    for (int i = 1; i < N + 1; i++) {
        cin >> wine[i];
    }

    dp[1] = wine[1];
    if (N > 1) {
        dp[2] = wine[1] + wine[2];
    }

    for (int i = 3; i < N + 1; i++) {
        dp[i] = max(dp[i - 1], max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
    }

    cout << dp[N];

    return 0;
} 