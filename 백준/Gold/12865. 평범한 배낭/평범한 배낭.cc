#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

static vector<int> weigth;
static vector<int> value;
static vector<vector<int> > dp;

int main() {
    int N, K; cin >> N >> K;
    weigth.resize(N + 1); value.resize(N + 1);
    dp.resize(N + 1, vector<int>(K + 1, 0));
    for (int i = 1; i < N + 1; i++) {
        cin >> weigth[i] >> value[i];
    }

    // logic
    for (int i = 1; i < N + 1; i++) {
        for (int w = 1; w < K + 1; w++) {
            if (w < weigth[i]) {
                dp[i][w] = dp[i - 1][w];
            }
            else {
                dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weigth[i]] + value[i]);
            }
        }
    }

    cout << dp[N][K] << endl;

    return 0;
}