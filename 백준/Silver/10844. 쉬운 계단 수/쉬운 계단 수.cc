#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>

// 10844

using namespace std;

const int MOD = 1000000000;

int main(void) {
	int N; cin >> N;

	long long dp[101][10] = {0};

	for (int i = 1; i < 10; i++) {
		dp[1][i] = 1;
	}

	for (int i = 2; i <= N; i++) {
		for (int j = 0; j < 10; j++) {
			if (j > 0) dp[i][j] += dp[i-1][j-1];
			if (j < 9) dp[i][j] += dp[i-1][j+1];
			dp[i][j] %= MOD;
		}
	}

	long long result = 0;
	for (int j = 0; j < 10; j++) {
		result += dp[N][j];
		result %= MOD;
	}

	cout << result;
	return 0;
}
