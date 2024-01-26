#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <cstdlib>
#include <cstring>

using namespace std;

int main(void) {
    int N, M; scanf("%d %d", &N, &M);

    // Input
    long long *arr = new long long[N];
    long long *S = new long long[N + 1];
    long long *C = new long long[M]; 
    memset(C, 0, sizeof(long long) * M);

    long long cnt = 0;
    S[0] = 0;
    
    for (int i = 0; i < N; i++) {
        scanf("%lld", &arr[i]);
        S[i + 1] = (S[i] + arr[i]) % M;
        if (S[i + 1] == 0) cnt++;
        C[S[i + 1]]++; 
    }

    for (int i = 0; i < M; i++) {
        if (C[i] > 1) {
            cnt += C[i]*(C[i]-1)/2;
        }
    }
    printf("%lld\n", cnt);

    delete[] arr;
    delete[] S;
    delete[] C;
    return 0;
}