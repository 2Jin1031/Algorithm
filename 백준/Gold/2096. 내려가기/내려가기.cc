#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>

// 2096

using namespace std;

int main(void) {
    int N;
    cin >> N;
    
    vector<pair<int, int> > D(3), temp(3);
    vector<int> current_row(3);  

    for (int j = 0; j < 3; j++) {
        cin >> current_row[j];
    }
    for (int j = 0; j < 3; j++) {
        D[j].first = current_row[j];
        D[j].second = current_row[j];
    }

    for (int i = 1; i < N; i++) {
        for (int j = 0; j < 3; j++) {
            cin >> current_row[j];
        }

        temp = D;
        for (int j = 0; j < 3; j++) {
            int max_val = 0, min_val = 0;
            for (int k = -1; k <= 1; k++) {
                int idx = j + k;
                if (idx >= 0 && idx < 3) {
                    if (max_val < temp[idx].first || max_val == 0) {
                        max_val = temp[idx].first;
                    }
                    if (min_val > temp[idx].second || min_val == 0) {
                        min_val = temp[idx].second;
                    }
                }
            }
            D[j].first = current_row[j] + max_val;
            D[j].second = current_row[j] + min_val;
        }
    }

    int resultMax = 0, resultMin = 0;
    for (int j = 0; j < 3; j++) {
        if (resultMax < D[j].first || resultMax == 0) resultMax = D[j].first;
        if (resultMin > D[j].second || resultMin == 0) resultMin = D[j].second;
    }

    cout << resultMax << " " << resultMin;
    return 0;
}