#include <iostream>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int main(void) {
    int N, M; cin >> N >> M;
    priority_queue<long long, vector<long long>, greater<long long> > pq;
    for (int i = 0; i < N; i++) {
        long x; cin >> x;
        pq.push(x);
    }
    for (int i = 0; i < M; i++) {
        long x = pq.top(); pq.pop();
        long y = pq.top(); pq.pop();
        pq.push(x + y);
        pq.push(x + y);
    }

    // result
    long long sum = 0;
    while (!pq.empty()) {
        sum += pq.top(); pq.pop();
    }
    cout << sum << endl;
}