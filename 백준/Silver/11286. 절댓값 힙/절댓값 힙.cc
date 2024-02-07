#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <deque>
#include <stack>
#include <queue>

using namespace std;

struct compare {
    bool operator() (int o1, int o2) {
        int first_abs = abs(o1);
        int second_abs = abs(o2);
        if (first_abs == second_abs) {
            return o1 > o2;
        }
        else {
            return first_abs > second_abs;
        }
    }
};

int main(void) {
    int N; scanf("%d", &N);

    priority_queue<int, vector<int>, compare> myQueue;

    int num;
    for (int i = 0; i < N; i++) {
        scanf("%d", &num);
        if (num == 0) {
            if (myQueue.empty()) {
                cout << "0\n";
            }
            else {
                cout << myQueue.top() << "\n";
                myQueue.pop();
            }
        }
        else {
            myQueue.push(num);
        }
    }
}
