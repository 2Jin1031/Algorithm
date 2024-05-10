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

static int arr[26] = {0};

int main(void) {
    int A, B, C, D; cin >> A >> B >> C >> D;

    C += D;
    B += C / 60;
    C = C % 60;
    A += B / 60;
    B = B % 60;
    A = A % 24;

    printf("%d %d %d", A, B, C);
}