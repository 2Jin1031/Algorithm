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

static int T;
static int A; 
static int B;
static int X;

int main(void) {
    cin >> T;
    for (int i = 0; i < T; i++) {
        scanf("%d %d %d", &A, &B, &X);
        printf("%d\n", A * (X - 1) + B);
    }
}