#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(void) {
    int N; cin >> N; getchar();
    int cntL = 0;
    for (int i = 0; i < N; i++) {
        char c; cin >> c;
        if (c == 'L') {
            cntL++;
        }
    }

    if (cntL == 0) {
        cout << N << endl;
        return 0;
    }

    cout << N - cntL + cntL / 2 + 1 << endl;
}