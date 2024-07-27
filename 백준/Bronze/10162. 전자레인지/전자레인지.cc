#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int main(void) {
    int T; cin >> T;
    int arr[3] = {300, 60, 10};

    int result[3];

    if (T % 10 != 0) {
        cout << -1 << endl;
        return 0;
    }

    for (int i = 0; i < 3; i++) {
        result[i] = T / arr[i];
        T %= arr[i];
    }

    for(int i = 0; i < 3; i++) {
        cout << result[i] << " ";
    }

}