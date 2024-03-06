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
static vector<int> A;
static int M;
static vector<int> B;

int binarySearch(int v) {

    auto lower = lower_bound(A.begin(), A.end(), v);
    auto upper = upper_bound(A.begin(), A.end(), v);

    return upper - lower;
}


int main(void) {
    scanf("%d", &N);
    A = vector<int> (N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    // sort
    sort(A.begin(), A.end());

    scanf("%d", &M);
    int v;
    for (int i = 0; i < M; i++) {
        scanf("%d", &v);
        printf("%d ", binarySearch(v));
    }

}