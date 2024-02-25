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

vector<int> splitInt(int n) {
    vector<int>().swap(A);
    while (n) {
        A.push_back(n%10);
        n /= 10;
    }

    return A;
}

int main(void) {
    int n, flag;
    while (1) {
        scanf("%d", &n); if (n == 0) break;
        flag = 0;
        A = splitInt(n);
        for (int i = 0; i < A.size() / 2; i++) {
            if (A[i] != A[A.size() - 1 - i]) {
                flag = 1;
                break;
            }
        }
        if (!flag) {
            printf("yes\n");
        }
        else {
            printf("no\n");
        }
    }
}