#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <cstdlib>
#include <cstring>

using namespace std;

int main(void) {
    int N; scanf("%d", &N);
    vector<long long> S;
    S.push_back(0); S.push_back(1);

    long long p = 2;
    long long cnt = 1;
    long long q;
    while (1) {
        q = S.at(p-1)+p;
        S.push_back(q);
        if ((N - q) % p == 0) cnt++;
        if (N <= q) break;
        p++;
    }
    if (N == 1) cnt = 1;
    printf("%lld", cnt);
}