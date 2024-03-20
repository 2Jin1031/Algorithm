#include <iostream>
#include <cstdio>
#include <string>
#include <cstring>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

static vector<int> A(9);
static int sum;

int main(void) {
    sum = 0;
    for(int i = 0; i < 9; i++) {
        scanf("%d", &A[i]);
        sum += A[i];
    }

    // sort
    sort(A.begin(), A.end());

    // 
    int idx1, idx2;
    for (int i = 0; i < 8; i++) {
        for (int j = i + 1; j < 9; j++) {
            int result = sum - A[i] - A[j];
            if (result == 100) {
                idx1 = i;
                idx2 = j;
            }
        }
    }

    // print
    for (int i = 0; i < 9; i++) {
        if (i != idx1 && i != idx2) {
            printf("%d\n", A[i]);
        }
    }
}