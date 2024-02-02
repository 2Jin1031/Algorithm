#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N; cin >> N;
    vector<int> V;

    for (int i = 0; i < N; i++) {
        int tmp; cin >> tmp;
        V.push_back(tmp);
    }

    if (N <= 2) {
        cout << "0\n";
        return 0;
    }

    sort(V.begin(), V.end());

    int cnt = 0;
    for (int i = 0; i < N; i++) {
        int target = V[i];

        int start = 0, end = N - 1;
        while (start < end) {
            if (start == i) {
                start++;
                continue;
            }
            if (end == i) {
                end--;
                continue;
            }

            int sum = V[start] + V[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                cnt++;
                break;
            }
        }
    }

    cout << cnt << "\n";

    return 0;
}
