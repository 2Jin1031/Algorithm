#include <iostream>
#include <string>

using namespace std;

int main() {
    int K, D, A;
    char slash;

    cin >> K >> slash >> D >> slash >> A;

    if (K + A < D || D == 0) {
        cout << "hasu" << endl;
    } else {
        cout << "gosu" << endl;
    }

    return 0;
}