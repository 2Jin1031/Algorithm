#include <iostream>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int main(void) {
    int N; cin >> N;

    vector<int> mountains(N);
    for (int i = 0; i < N; i++) {
        cin >> mountains[i];
    }

    int maxCnt = 0;
    int cnt = 0;
    for (int i = 0; i < N; i++) {
        cnt = 0;
        for (int j = i + 1; j < N; j++) {
            if (mountains[i] > mountains[j]) {
                cnt++;
            } else {
                break;
            }
        }
        if (cnt > maxCnt) {
            maxCnt = cnt;
        }
    }

    cout << maxCnt;
}