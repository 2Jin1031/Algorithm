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
struct compare {
    bool operator()(int i, int j) {
        int first = abs(i);
        int second = abs(j);

        if (first == second) {
            return i > j;
        }
        else {
            return first > second;
        }
    }
};

int main(void) {
    int N; scanf("%d", &N);

    priority_queue<int, vector<int>, compare> pq;
    int now;
    for (int i = 0; i < N; i++) {
        scanf("%d", &now);

        if (now == 0) {
            if (pq.size()) {
                printf("%d\n", pq.top());
                pq.pop();
            }
            else {
                printf("0\n");
            }
        }
        else {
            pq.push(now);
        }

    }
}