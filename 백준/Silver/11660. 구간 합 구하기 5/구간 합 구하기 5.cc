#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <cstdlib>

using namespace std;

int main(void) {
    int N, M; scanf("%d %d", &N, &M);

    // Input
    int **arr = (int **)malloc(sizeof(int *) * N); if (arr == NULL) return -1;
    for (int i = 0; i < N; i++) {
        arr[i] = (int *)malloc(sizeof(int) * N); if (arr[i] == NULL) return -1;
        for (int j = 0; j < N; j++) {
            scanf("%d", &arr[i][j]);
        }
    }

    // S
    int **S = (int **)malloc(sizeof(int *) * N); if (S == NULL) return -1;
    S[0] = (int *)malloc(sizeof(int) * N); if (S[0] == NULL) return -1;
    S[0][0] = arr[0][0];

    for (int i = 1; i < N; i++) {
        S[i] = (int *)malloc(sizeof(int) * N);
        S[i][0] = S[i-1][0] + arr[i][0];
    }
    for (int j = 1; j < N; j++) {
        S[0][j] = S[0][j-1] + arr[0][j];
    }

    for (int i = 1; i < N; i++) {
        for (int j = 1; j < N; j++) {
            S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + arr[i][j];
        }
    }

    int x1, y1, x2, y2;
    int result;
    for (int i = 0; i < M; i++) {
        scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
        if (x1 == 1 && y1 == 1) {
            result = S[x2-1][y2-1];
        }
        else if (x1 == 1 && y1 != 1) {
            result = S[x2-1][y2-1] - S[x2-1][y1-2];
        }
        else if (x1 != 1 && y1 == 1) {
            result = S[x2-1][y2-1] - S[x1-2][y2-1];
        }
        else {
            result = S[x2-1][y2-1] - S[x1-2][y2-1] - S[x2-1][y1-2] + S[x1-2][y1-2];
        }
        printf("%d\n", result);
    }

}