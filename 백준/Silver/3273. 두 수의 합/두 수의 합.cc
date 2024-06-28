#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <string>
#include <cmath>

using namespace std;

static vector<int> sequence;

int main(void) {
    int n; cin >> n; sequence.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> sequence[i];
    }

    int x; cin >> x;

    sort(sequence.begin(), sequence.end());

    int startIdx = 0, endIdx = sequence.size() - 1;

    int sum = -1;
    int answer = 0;
    while (1) {
        sum = sequence[startIdx] + sequence[endIdx];
        if (sum > x) {
            endIdx--;
        }
        else if (sum < x) {
            startIdx++;
        }
        else {
            endIdx--;
            startIdx++;
            answer++;
        }

        if (startIdx >= endIdx) {
            break;
        }
    }
    cout << answer;
}