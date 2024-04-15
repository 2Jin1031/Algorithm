#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>


// 1026
using namespace std;

static int N;
static vector<int> A;
static vector<int> B;

int compare(int i, int j) {
    return i > j;
}

int main(void) {
    scanf("%d", &N); A.resize(N); B.resize(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    for (int i = 0; i < N; i++) {
        cin >> B[i];
    }

    sort(A.begin(), A.end());
    sort(B.begin(), B.end(), compare);

    int result = 0;
    for (int i = 0; i < N; i++) {
        result += A[i] * B[i];
    }

    cout << result;
    return 0;
}