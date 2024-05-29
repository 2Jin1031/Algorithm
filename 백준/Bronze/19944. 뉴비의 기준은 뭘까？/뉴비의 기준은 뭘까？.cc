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

using namespace std;

int main(void) {
    int N, M; cin >> N >> M;
    if (M == 1 || M == 2) {
        cout << "NEWBIE!";
        return 0;
    }
    if (M <= N) {
        cout << "OLDBIE!";
        return 0;
    }
    cout << "TLE!";
}