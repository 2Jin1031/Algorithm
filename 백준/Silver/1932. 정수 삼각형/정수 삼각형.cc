#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>


// 16953
using namespace std;

static int N;
static vector<vector<int> > A;
static vector<int> D;

int main(void) {
    scanf("%d", &N); A.resize(N); D.resize(N);
    
    // input A
    int tmp;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j <= i; j++) {
            scanf("%d", &tmp); A[i].push_back(tmp);
        }
    }

    // logic (dp)
    //// logic (N - 1 line)
    for (int i = 0; i < N; i++) {
        D[i] = A[N-1][i];
    }

    for (int i = N - 2; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
            int findmax = max(D[j], D[j+1]);
            D[j] = A[i][j] + findmax;
        } 
    }

    // print
    printf("%d", D[0]);

    return 0;
}