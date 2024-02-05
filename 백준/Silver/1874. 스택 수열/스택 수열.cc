#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <deque>
#include <stack>

using namespace std;

typedef pair<int, int> Node;

int main(void) {
    int n; scanf("%d", &n);
    vector<int> A(n);
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }
    vector<int> C(n);
    stack<int> myStack;
    vector<char> R;
    int flag = 0; // 마지막 도달 flag
    int num = 1;
    for (int i = 0; i < n; i++) {
        int su = A[i];
        if (su >= num) {
            if (su == n) flag = 1;
            while (su >= num) {
                myStack.push(num++);
                R.push_back('+');
            }
            myStack.pop();
            R.push_back('-');
        }
        else if (myStack.top() == su) {
            myStack.pop();
            R.push_back('-');
        }
        else {
            printf("NO");
            return 0;
        }
    }
    for (int i = 0; i < R.size(); i++) {
        printf("%c\n", R[i]);
    }

    return 0;
}
