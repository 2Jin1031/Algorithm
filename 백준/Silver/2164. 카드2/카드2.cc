#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <deque>
#include <stack>

using namespace std;

int main(void) {
    int N; scanf("%d", &N);
    deque<int> myDeque(N);

    
    for (int i = 0; i < N; i++) {
        myDeque[i] = i + 1;
    }

    while (1) {
        if (myDeque.size() == 1) {
            printf("%d", myDeque.front());
            return 0;
        }
        myDeque.pop_front();
        int tmp = myDeque.front();
        myDeque.pop_front();
        myDeque.push_back(tmp);
    }
}
