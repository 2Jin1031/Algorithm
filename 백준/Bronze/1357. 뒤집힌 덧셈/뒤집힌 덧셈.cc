#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

int ftRev(int num) {
    int result = 0;
    while (num) {
        result = result * 10 + num % 10;
        num /= 10;
    }

    return result;
}

int main(void) {
    int X, Y; cin >> X >> Y;

    int result = ftRev(ftRev(X) + ftRev(Y));

    cout << result;

}