#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;

static int A[4];
static int B[4];

static int totalA = 0;
static int totalB = 0;

int main(void) {
    // input
    for (int i = 0; i < 4; i++) {
        cin >> A[i];
        totalA += A[i];
    }
    for (int i = 0; i < 4; i++) {
        cin >> B[i];
        totalB += B[i];
    }

    (totalA > totalB) ? cout << totalA : cout << totalB;
}