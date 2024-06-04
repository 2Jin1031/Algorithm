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
    int A, B; cin >> A >> B;
    int C; cin >> C;

    int total = A + B;
    int chicken = C * 2;

    if (total < chicken) {
        cout << total;
        return 0;
    }
    cout << total - chicken;
    
}