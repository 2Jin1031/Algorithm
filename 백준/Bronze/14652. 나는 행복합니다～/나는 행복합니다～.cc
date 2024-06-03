#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>
#include <stack>
#include <iomanip>

using namespace std;

int main(void) {
    int N, M, K; cin >> N >> M >> K;
    int n = K / M;
    int m = K % M;
    cout << n << " " << m;

}