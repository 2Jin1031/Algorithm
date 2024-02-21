#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>

using namespace std;

static int A[16][16];
static vector<bool> visited;

int main(void) {
    int N, M; scanf("%d %d", &N, &M);

    vector<int> A = vector<int> (N, 0);
    scanf("%d", &A[1]);

    for (int i = 2; i < N + 1; i++) {
        scanf("%d", &A[i]);
        A[i] = A[i - 1] + A[i];
       
    }

    int a, b;
    int result;
    for (int i = 0; i < M; i++) {
        result = 0;
        scanf("%d %d", &a, &b);
        printf("%d\n", A[b] - A[a - 1]);
    }
    
}