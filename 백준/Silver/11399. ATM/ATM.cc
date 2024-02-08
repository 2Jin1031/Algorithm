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
    vector<int> A(N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }
    // sort
    sort(A.begin(), A.end());

    // rogic
    int sum = A[0];
    for(int i = 1; i < N; i++) {
        A[i] = A[i - 1] + A[i];
        sum += A[i];
    }
    printf("%d", sum);
}
