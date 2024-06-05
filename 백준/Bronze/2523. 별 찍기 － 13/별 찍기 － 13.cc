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
#include <iomanip>

using namespace std;

int main(void) {
    int N; cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j <= i; j++) {
            cout << "*";
        } cout << "\n";
    }
    for (int i = N - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            cout << "*";
        } cout << "\n";
    }
}