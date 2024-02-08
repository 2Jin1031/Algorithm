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
    int N, K; scanf("%d %d", &N, &K);
    vector<int> A(N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }
    
    // sort
    sort(A.begin(), A.end());

    printf("%d", A[K-1]);
}
