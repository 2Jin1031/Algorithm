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
    queue<int> A;
    for (int i = 0; i < N; i++) {
        A.push(i + 1);
    }

    while (1) {
        if (A.size() == 1) {
            break;
        }
        A.pop();
        A.push(A.front());
        A.pop();
    }
    printf("%d", A.front());
}