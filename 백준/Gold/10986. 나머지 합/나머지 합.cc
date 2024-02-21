#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>

using namespace std;

static vector<long> A;
static vector<long> D;
static vector<long> C;
static vector<bool> visited;

int main(void) {
    int N, M; scanf("%d %d", &N, &M);
    A = vector<long> (N + 1, 0);
    D = vector<long> (N + 1, 0);

    for (int i = 1; i < N + 1; i++) {
        scanf("%ld", &A[i]);
        D[i] = (D[i-1] + A[i]) % M;
    }
    
    C = vector<long> (M, 0);
    for (int i = 1; i < N + 1; i++) {
        C[D[i]]++;
    }
    
    long result = C[0];
    for (int i = 0; i < M; i++) {
        result += (C[i] * (C[i] - 1)) / 2;
    }
    printf("%ld", result);
    
}