#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>

using namespace std;

static vector<int> A;

int main(void) {
    int N, K; scanf("%d %d", &N, &K);

    A = vector<int> (N);

    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    int count = 0;
    for (int i = N - 1; i >= 0; i--) {
        if (A[i] <= K) { // count coin
            count += K / A[i];
            K = K % A[i];
        }
        if (!K) // count end break
            break;
    }
    printf("%d", count);
}