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
    int arr[7];
    for (int i = 0; i < 7; i++) {
        cin >> arr[i];
    }

    // logic
    int result = 0;
    int min = -1;
    for (int i = 0; i < 7; i++) {
        if (arr[i] % 2 == 1) {
            result += arr[i];
            if (min > arr[i] || min == -1) {
                min = arr[i];
            }
        }
    }
    if (min == -1) {
        cout << min;
        return 0;
    }
    cout << result << endl << min;
}