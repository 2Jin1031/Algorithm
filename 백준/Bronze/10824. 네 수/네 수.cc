#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

static int N;

int main(void) {
    long long A[4];
    for (int i = 0; i < 4; i++) {
        cin >> A[i];
    }

    int tmp1 = A[1];
    while (tmp1 > 0) {
        tmp1 /= 10;
        A[0] *= 10;
    }
    A[0] += A[1];

    tmp1 = A[3];
    while (tmp1 > 0) {
        tmp1 /= 10;
        A[2] *= 10;
    }
    A[2] += A[3];

    cout << A[0] + A[2]; 
}