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
static int M;
static vector<int> A;
static vector<int> B;

int main(void) {
    scanf("%d", &N);

    int result = 0;
    for (int i = 0; i < N; i++) {
        int tmp; scanf("%d", &tmp);
        result += tmp;
    }

    printf("%d", result - N + 1);
}