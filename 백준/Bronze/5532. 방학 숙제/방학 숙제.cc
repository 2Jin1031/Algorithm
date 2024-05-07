#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>
#include <stack>

// 

using namespace std;

int main(void) {
    int L, A, B, C, D; cin >> L >> A >> B >> C >> D;
    int result1 = A / C;
    int result2 = B / D;

    result1 +=  (A % C) ? 1 : 0;
    result2 += (B % D) ? 1 : 0;

    if (result1 > result2) {
        result2 = result1;
    }
    
    cout << L - result2;
}
