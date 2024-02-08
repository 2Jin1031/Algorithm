#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <deque>
#include <stack>
#include <queue>

using namespace std;

int main(void) {
    int N; scanf("%d", &N);
    vector<pair<int, int> > A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i].first;
        A[i].second = i;
    }
    sort(A.begin(), A.end());
    int Max = 0;

    for (int i = 0; i < N; i++) {
        if (Max < A[i].second - i) {
            Max = A[i].second - i;
        }
    }

    cout << Max + 1;
}
