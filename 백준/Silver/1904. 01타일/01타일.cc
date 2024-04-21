#include <iostream>
#include <vector>
using namespace std;

int main(void) {
    int N;
    cin >> N;
    vector<int> dp(N+1, 0);
    dp[0] = 1; // 공집합
    dp[1] = 1; // "1"만 있는 경우

    for (int i = 2; i <= N; i++) {
        dp[i] = (dp[i-1] + dp[i-2]) % 15746; // "1"을 추가하거나 "00"을 추가
    }

    cout << dp[N];

    return 0;
}
