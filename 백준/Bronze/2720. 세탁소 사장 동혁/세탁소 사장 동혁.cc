#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

static int change[4] = {25, 10, 5, 1};

int main(void) {
    int T; cin >> T;
    
    int C;
    for (int i = 0; i < T; i++) {
        cin >> C;
        for (int j = 0; j < 4; j++) {
            cout <<  C / change[j] << " ";
            C %= change[j];
        } cout << "\n";
    }
}