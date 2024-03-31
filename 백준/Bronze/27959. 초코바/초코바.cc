#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;

static int N;
static int M; 

int main(void) {
    cin >> N >> M;
    (N * 100 >= M) ? cout << "Yes" : cout << "No";
}
