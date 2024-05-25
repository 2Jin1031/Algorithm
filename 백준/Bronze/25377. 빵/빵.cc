#include <iostream>
#include <locale>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    int N; cin >> N;
    int a, b;
    int min = -1;
    for (int i = 0; i < N; i++) {
        cin >> a >> b;
        if (a <= b) {
            if (min > b || min == -1) {
                min = b;
            }
        }
    }
    cout << min;
}

