#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>
#include <tuple>
#include <utility>
#include <climits>


// 
using namespace std;

int main(void) {
    int K, N, M; cin >> K >> N >> M;
    int result = K * N - M;
    if (result < 0) result = 0;
    
    cout << result;
}