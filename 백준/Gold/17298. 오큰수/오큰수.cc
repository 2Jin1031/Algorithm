#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <deque>
#include <stack>

using namespace std;

typedef pair<int, int> Node;

int main(void) {
    int N; scanf("%d", &N);
    // Input
    vector<int> A(N);
    vector<int> ans(N, 0);
    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    // Logic
    stack<int> myStack;
    myStack.push(0);
    for (int i = 1; i < N; i++) {
        while (!myStack.empty() && A[myStack.top()] < A[i]) {
            ans[myStack.top()] = A[i];
            myStack.pop();
        }
        myStack.push(i);
    }
    while (!myStack.empty()) {
        ans[myStack.top()] = -1;
        myStack.pop();
    }
    for (int i = 0; i < N; i++) {
        printf("%d ", ans[i]);
    }
}
