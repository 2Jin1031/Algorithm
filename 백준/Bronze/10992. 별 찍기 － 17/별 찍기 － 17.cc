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

int main(void) {
    int N; cin >> N;
    // first
    for (int i = 0; i < N - 1; i++) {
        cout << " ";
    } cout << "*\n";
    if (N == 1) return 0;
    // middle
    for (int i = 1; i < N - 1; i++) {
        for (int j = i; j < N - 1; j++) cout << " ";
        cout <<"*";
        for (int j = 0; j < i * 2 - 1; j++) {
            cout << " ";
        }
        cout << "*\n";
    }
    // last
    for (int i = 2; i < N * 2 + 1; i++) {
        cout << "*";
    }

    return 0;
}