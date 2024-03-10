#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;

static int N;
static vector<string> A;
static int M;
static vector<string> D;

bool ft_binarySearch(string str) {
    int begin = 0, end = A.size() - 1;

    while (begin <= end) {
        int midi = (begin + end) / 2;
        string midv = A[midi];

        if (midv == str) {
            return true;
        }
        else if (midv > str) {
            end = midi - 1;
        }
        else { // midv < str
            begin = midi + 1;
        }
    }
    return false;
}

int main(void) {
    scanf("%d %d", &N, &M);
    A = vector<string>(N);

    // A input
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }

    // sort A
    sort(A.begin(), A.end());

    // M input

    for (int i = 0; i < M; i++) {
        string str; cin >> str;
        if (ft_binarySearch(str)) {
            D.push_back(str);
        }
    }

    // D sort
    sort(D.begin(), D.end());

    // print
    cout << D.size() << "\n";
    for (int i = 0; i < D.size(); i++) {
        cout << D[i] << "\n";
    }
}