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

using namespace std;


int main(void) {
    int N; scanf("%d", &N);
    static vector<int> D = vector<int> (N + 2);
    static vector<int> T = vector<int> (N + 1);
    static vector<int> P = vector<int> (N + 1);

    for (int i = 1; i < N + 1; i++) {
        cin >> T[i] >> P[i];
    }
    
    for (int i = N; i > 0; i--) {
        if (i + T[i] > N + 1) {
            D[i] = D[i + 1]; 
        }
        else {
            D[i] = max(D[i + 1], P[i] + D[i + T[i]]);
        }
    }
    cout << D[1];
}