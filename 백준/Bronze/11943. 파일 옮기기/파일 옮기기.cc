#include <iostream>
#include <locale>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    int a, b, c, d; cin >> a >> b >> c >> d;
    int result = min(a + d, b + c);
    cout << result;

    return 0;
}