#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>

using namespace std;

static vector<int> A;

int main(void) {
    int N; scanf("%d", &N);

    priority_queue<int, vector<int>, greater<int> > pq; // 오름차순 정렬

    int data;
    for (int i = 0; i < N; i++) {
        scanf("%d", &data);
        pq.push(data);
    }

    int data1 = 0, data2 = 0;
    int sum = 0;

    while (pq.size() != 1) {
        data1 = pq.top();
        pq.pop();
        data2 = pq.top();
        pq.pop();
        sum += data1 + data2;
        pq.push(data1 + data2);
    }

    printf("%d", sum);
}