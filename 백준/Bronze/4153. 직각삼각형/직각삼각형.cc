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
static vector<int> A;

int main(void) {
    A = vector<int> (3);
    while (1) {
        scanf("%d %d %d", &A[0], &A[1], &A[2]);
        if (A[0] == 0 && A[1] == 0 && A[2] == 0) {
            break;
        }

        //sort
        sort(A.begin(), A.end());

        if (A[2] * A[2] == (A[0] * A[0] + A[1] * A[1])) {
            printf("right\n");
        }
        else {
            printf("wrong\n");
        }
    }
}