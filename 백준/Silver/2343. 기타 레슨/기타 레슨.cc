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

static int N, M;
static vector<int> A;

int main(void) {
    scanf("%d %d", &N, &M);
    A = vector<int> (N);

    int start = 0, end = 0;
    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
        if (start < A[i]) {
            start = A[i];
        }
        end += A[i];
    }

    while (start <= end) {
        int middle = (start + end) / 2;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (sum + A[i] > middle) {
                count++;
                sum = 0;
            }
            sum += A[i];
        }
        if (sum != 0) {
            count++;
        } 
        if (count > M) {
            start = middle + 1;
        }
        else {
            end = middle - 1;
        }
    }
    cout << start << "\n";
}