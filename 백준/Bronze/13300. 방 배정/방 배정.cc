#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>
#include <stack>
#include <iomanip>

using namespace std;

int main(void) {
    int N, K; cin >> N >> K;
    int arr[6][2] = {0};
    for (int i = 0; i < N; i++) {
        int S, Y; cin >> S >> Y;
        arr[Y - 1][S]++;
    }

    int result = 0;
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 2; j++) {
            if (arr[i][j] != 0) {
                result += arr[i][j] / K;
                if (arr[i][j] % K) result++;
            }
        }
    }

    cout << result;
}