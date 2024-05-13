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

static int arr[5];

using namespace std;

int main(void) {
    int L, P; cin >> L >> P;

    for (int i = 0; i < 5; i++) {
        cin >> arr[i];
    }

    int result = L * P;
    for (int i = 0; i < 5; i++) {
        cout << arr[i] - result << " ";
    }

    return 0;
}