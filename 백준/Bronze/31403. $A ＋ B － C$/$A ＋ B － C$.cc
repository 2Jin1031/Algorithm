#include <iostream>
#include <locale>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    int a, b, c; cin >> a >> b >> c;
    cout << a + b - c << endl;
    
    
    string sa = to_string(a);
    string sb = to_string(b);
    string sc = to_string(c);
    int strResult = stoi(sa + sb) - stoi(sc);
    cout << strResult << endl;

    return 0;
}