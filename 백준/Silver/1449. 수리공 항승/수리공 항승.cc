#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>
#include <climits>
#include <cstdio>

using namespace std;

int main(void) {
    int N, L; cin >> N >> L;
    vector<int> A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }

    sort(A.begin(), A.end());

    int cnt = 1;
    int endTape = A[0] + L - 0.5;
    for (int i = 1; i < N; i++) {
        if (endTape < A[i] - 0.5) {
            cnt++;
            endTape = A[i] + L - 0.5;
        }
    }
    cout << cnt << endl;
}