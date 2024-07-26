#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int compare(const int &a, const int &b) {
    return a > b;
};

int main(void) {
    int N; cin >> N;

    vector<int> A = vector<int>(N);
    int sum = 0;
    for (int i = 0; i < N; i++) {
        cin >> A[i];
        sum += A[i];
    }
    int avg = sum / N;

    // sort
    sort(A.begin(), A.end(), compare);

    int maxRes = 0;
    for (int i = 0; i < N; i++) {
        if (A[i] * (i + 1) > maxRes) {
            maxRes = A[i] * (i + 1);
        }
    }
    cout << maxRes << endl;
}