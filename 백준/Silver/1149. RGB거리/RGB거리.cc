#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>

// #1149

using namespace std;

static int N;
static vector<vector<int> > A;
static vector<vector<int> > D;

void ft_logic(int column, int row) {
    for (int i = 0; i < 3; i++) {
        if (i != row) {
            int candidate = A[column][row] + D[column + 1][i];
            if (D[column][row] == 0 || candidate < D[column][row]) {
                D[column][row] = candidate;
            }
        }
    }
}

int main(void) {
    scanf("%d", &N);

    A.resize(N, vector<int>(3));
    D.resize(N, vector<int>(3, 0));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < 3; j++) {
            scanf("%d", &A[i][j]);
        }
    }

    // logic
    for (int j = 0; j < 3; j++) {
        D[N-1][j] = A[N-1][j];
    }

    // 로직
    for (int i = N - 2; i >= 0; i--) {
        for (int j = 0; j < 3; j++) {
            ft_logic(i, j);
        }
    } 
    
    // find min
    int result = 0;
    for (int i = 0; i < 3; i++) {
        if (D[0][i] < result || result == 0) {
            result = D[0][i];
        }
    }
    
    // print
    printf("%d", result);

    return 0;
}