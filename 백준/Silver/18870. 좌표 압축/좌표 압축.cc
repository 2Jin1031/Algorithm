#include <iostream>
#include <vector>
#include <algorithm> // Include for sort and greater

using namespace std;

int main() {
    int N;
    scanf("%d", &N);
    vector<pair<int, int>> arr(N);
    vector<int> R(N);

    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i].first);
        arr[i].second = i;  // store the original index
    }

    // Sort by value, maintaining original indices
    sort(arr.begin(), arr.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
        return a.first < b.first;
    });

    // Assign ranks
    int rank = 0;
    for (int i = 0; i < N; i++) {
        if (i > 0 && arr[i].first != arr[i - 1].first) {
            rank++;
        }
        R[arr[i].second] = rank;
    }

    // Output results
    for (int i = 0; i < N; i++) {
        printf("%d ", R[i]);
    }
    
    return 0;
}
