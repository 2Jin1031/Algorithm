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
    
    // print
        // first line
    for (int i = 0; i < N - 1; i++) {
        cout << " ";
    }
    cout << "*\n";
        // rest line
    for (int i = 1; i < N; i++) {
        for (int j = i; j < N - 1; j++) {
            cout << " ";
        }
        cout << "*";
        for (int j = 0; j < i * 2 - 1; j++) {
            cout << " ";
        }
        cout << "*\n";
    }
}