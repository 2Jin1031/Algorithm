#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>

using namespace std;

static vector<vector<int> > A;
static vector<bool> visited;

int main(void) {
    int N, M; scanf("%d %d", &N, &M);
    A = vector<vector<int> >(N + 1, vector<int> (N + 1, 0));

    // Input A
    int tmp;
    for (int i = 1; i < N + 1; i++) {
        for (int j = 1; j < N + 1; j++) {
            scanf("%d", &A[i][j]);
        }
    }

    

    // Sum Vector
    for (int i = 1; i < N + 1; i++) {
        for (int j = 1; j < N + 1; j++) {
            A[i][j] = A[i][j] + A[i-1][j] + A[i][j-1] - A[i-1][j-1];
        }
    }

    // Input M
    int x1, x2, y1, y2;
    for (int i = 0; i < M; i++) {
        scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
        printf("%d\n", A[x2][y2] - A[x2][y1 - 1] - A[x1 - 1][y2] + A[x1-1][y1-1]);
    }
}