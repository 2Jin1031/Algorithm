#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>

using namespace std;

static vector<int> A;
typedef pair<int, int> Node;

int compare(int i, int j) {

}
int main(void) {
    int N, L; scanf("%d %d", &N, &L);

    A = vector<int>(N);
    deque<Node> myDeque;
    
    int now;
    for (int i = 0; i < N; i++) {
        scanf("%d", &now);

        while (myDeque.size() && myDeque.back().first > now) {
            myDeque.pop_back();
        }
        myDeque.push_back(Node(now, i));

        if (myDeque.front().second <= i - L) {
            myDeque.pop_front();
        }

        printf("%d ", myDeque.front().first);
    }
}