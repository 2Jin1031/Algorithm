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

static int A[5];
static int sum = 0;

int main(void) {
    for (int i = 0; i < 5; i++) {
        scanf("%d", &A[i]);
        sum += A[i];
    }
    printf("%d", sum);
}