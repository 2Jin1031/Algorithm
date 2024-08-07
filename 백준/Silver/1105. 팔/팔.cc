#include <iostream>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int main(void) {
    string L, R; cin >> L >> R;
    
    if (L.size() != R.size()) {
        cout << 0 << endl;
        return 0;
    }

    int cnt = 0;
    for (int i = 0; i < L.size(); i++) {
        if (L[i] == R[i] && L[i] == '8') cnt++;
        else if (L[i] != R[i]) break;
    }

    cout << cnt << endl;
}