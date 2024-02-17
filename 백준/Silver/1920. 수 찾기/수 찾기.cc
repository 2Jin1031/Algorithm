#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>

using namespace std;

int main(void) {
    int N, M; scanf("%d", &N);
    vector<int> A(N);

    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    // Sort
    sort(A.begin(), A.end());

    cin >> M;

    for (int i = 0; i < M; i++) {
        bool find = false;
        int target; scanf("%d", &target);
        int start = 0, end = A.size() - 1;

        while (start <= end) {
            int midi = (start + end) / 2;
            int midV = A[midi];

            if (midV > target) {
                end = midi - 1;
            }
            else if (midV < target) {
                start = midi + 1;
            }
            else {
                find = true;
                break;
            }
        }
        if (find) {
            printf("1\n");
        }
        else {
            printf("0\n");
        }
    }
}