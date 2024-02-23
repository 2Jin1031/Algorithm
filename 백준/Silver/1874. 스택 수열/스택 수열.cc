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

int main(void) {
    int N; scanf("%d", &N);
    vector<int> A = vector<int> (N);
    vector<char> D;
    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    stack<int> S;

    S.push(1);
    D.push_back('+');
    int now = 2;
    int i = 0;
    while (i < N) {
        if (!S.size() || S.top() < A[i]) {
            while (!S.size() || S.top() < A[i]) {
                S.push(now);
                D.push_back('+');
                now++;
            }
            S.pop();
            D.push_back('-');
        }
        else {
            if (S.top() == A[i]) {
                S.pop();
                D.push_back('-');
            }
            else {
                printf("NO");
                return 0;
            }
        }
        i++;
    }

    for (int i = 0; i < D.size(); i++) {
        printf("%c\n", D[i]);
    }
}