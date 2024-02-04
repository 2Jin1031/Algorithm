#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <deque>

using namespace std;

typedef pair<int, int> Node;

int main(void) {
    int N, L; scanf("%d %d", &N, &L);
    deque<Node> mydeque;

    // Input
    vector<int> D(N);
    for (int i = 0; i < N; i++) {
        int now; scanf("%d", &now);

        while(mydeque.size() && mydeque.back().first > now) {
            mydeque.pop_back();
        }
        mydeque.push_back(Node(now, i));

        if (mydeque.front().second <= i - L) {
            mydeque.pop_front();
        }

        printf("%d ", mydeque.front().first);
    }
}