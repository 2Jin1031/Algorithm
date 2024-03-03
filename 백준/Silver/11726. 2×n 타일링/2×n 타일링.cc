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

static int N;
static vector<long> D;
static long mod = 10007;

int main(void) {
    cin >> N;
    D = vector<long> (N + 1);

    D[0] = 1;
    D[1] = 1;
    for (int i = 2; i < N + 1; i++) {
        D[i] = (D[i - 2] + D[i - 1]) % mod;
    }

    printf("%ld", D[N]);
}