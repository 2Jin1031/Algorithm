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
#include <cstdlib>

using namespace std;

static int A, B;
static vector<int> S;

void ftmakeSum (int cnt, int num) {
    if (S.size() > B) {
        return ;
    }
    if (cnt == num) {
        cnt = -1;
        num++;
    }
    else {
        S.push_back(S.back() + num);
    }
    ftmakeSum(cnt + 1, num);
}

int main(void) {
    cin >> A >> B;

    // init
    S.push_back(0);
    ftmakeSum(0, 1);    

    cout << S[B] - S[A - 1];
}