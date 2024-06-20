#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

int main(void) {
    int N; cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = i; j < N - 1; j++) {
            cout << " ";
        }
        for (int j = 0; j < (i + 1); j++) {
            cout << "* ";
        } cout << "\n";
    }
}