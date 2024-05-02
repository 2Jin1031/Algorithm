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


// 4470
using namespace std;

static vector<string> A;

int main(void) {
    int n; cin >> n; A.resize(n); getchar();
    for (int i = 0; i < n; i++) getline(cin, A[i]);

    // print
    for (int i = 0; i < n; i++) {
        cout << i + 1 << ". " << A[i] << endl;
    }

    return 0;
}