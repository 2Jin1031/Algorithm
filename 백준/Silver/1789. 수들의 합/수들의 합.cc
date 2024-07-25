#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int main(void) {
    long long N; cin >> N;
    int result = ((-1 + sqrt(1 + 8 * N)) / 2);
    cout << result;
}