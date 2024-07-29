#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <queue>
#include <functional>

using namespace std;

int main(void) {
    int N; cin >> N;
    // city
    vector<long long> city(N - 1);
    vector<long long> sumCity = vector<long long>(N, 0);
    for (int i = 0; i < N - 1; i++) {
        cin >> city[i];
        sumCity[i + 1] = sumCity[i] + city[i];
    }

    // cost
    vector<int> cost(N);
    priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > pq;
    for (int i = 0; i < N; i++) {
        cin >> cost[i];
        pq.push(make_pair(cost[i], i));

    }
    
    // result
    int findIdx = N - 1;
    long long result = 0;
    while (findIdx > 0) {
        while (!pq.empty() && pq.top().second >= findIdx) {
            pq.pop();
        }
        if (pq.empty()) break;
        
        result += pq.top().first * (sumCity[findIdx] - sumCity[pq.top().second]);
        findIdx = pq.top().second;
    }
    cout << result;
}