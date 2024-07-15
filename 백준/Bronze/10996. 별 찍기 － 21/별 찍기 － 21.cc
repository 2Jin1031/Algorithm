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
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N / 2 + (N % 2); j++) {
            cout << "* ";
        }
        cout << "\n";
        for (int j = 0; j < N / 2; j++) {
            cout << " *";
        }
        cout << "\n";
    }
    
    return 0;
}