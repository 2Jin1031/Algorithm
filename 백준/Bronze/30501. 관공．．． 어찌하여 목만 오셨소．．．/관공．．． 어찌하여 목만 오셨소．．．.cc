#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(void) {
    int N; cin >> N;

    vector<string> A = vector<string>(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }

    // find
    for (int i = 0; i < N; i++) {
        if (A[i].find('S') != string::npos) {
            cout << A[i];
            return 0;
        }
    }
}