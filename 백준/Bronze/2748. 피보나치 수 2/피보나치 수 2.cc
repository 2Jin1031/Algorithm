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
#include <cstdlib>

using namespace std;

int ftFibo(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return ftFibo(n - 1) + ftFibo(n - 2);
}

int main(void) {
    int N; cin >> N;
    if (N == 0) {
        cout << 0;
        return 0;
    }
    if (N == 1) {
        cout << 1;
        return 0;
    }

    vector<long long> fib(N + 1);
    fib[0] = 0;
    fib[1] = 1;

    for (int i = 2; i <= N; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }

    cout << fib[N];

    return 0;
}