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
    int a, b, c, d, e; cin >> a >> b >> c >> d >> e;
    int result1 = min({a, b, c});

    int result2 = min(d, e);

    cout << result1 + result2- 50;

}