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
    int d1, d2; 
    cin >> d1 >> d2;

    double result = d1 * 2 + 2 * 3.141592 * d2;

    cout << fixed << setprecision(6) << result << endl;

    return 0;
}