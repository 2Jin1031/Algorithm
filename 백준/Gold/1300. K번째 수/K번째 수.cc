#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;


int main(void) {
    long N, K; scanf("%ld %ld", &N, &K);
    long start = 1, end = K;
    long ans = 0;

    while (start <= end) {
        long middle = (start + end) / 2;
        long cnt = 0;

        for (int i = 1; i <= N; i++) {
            cnt += min(middle/i, N);
        }
        if (cnt < K) {
            start  = middle + 1;
        }
        else {
            ans = middle;
            end = middle - 1;
        }
    }
    printf("%d", ans);
}