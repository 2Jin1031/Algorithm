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
    for (int i = 0; i < N; i++) {
        if (i % 2 == 1) cout << " ";
        for (int j = 0; j < N; j++) {
            cout << "* ";
        } cout << "\n";
    }
}