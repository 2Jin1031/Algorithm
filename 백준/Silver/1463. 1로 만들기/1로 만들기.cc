#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>

using namespace std;

static vector<int> A;

int main(void) {
    int N; scanf("%d", &N);
    A = vector<int> (N + 1);
    A[1] = 0;

    for (int i = 2; i < N + 1; i++) {
        A[i] = A[i - 1] + 1;
        if (i % 2 == 0) A[i] = min(A[i], A[i/2] + 1);
        if (i % 3 == 0) A[i] = min(A[i], A[i/3] + 1);
    }

    printf("%d", A[N]);
}